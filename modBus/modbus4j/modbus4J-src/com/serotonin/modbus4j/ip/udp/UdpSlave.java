/*
 * Created on 28-Sep-2006
 */
package com.serotonin.modbus4j.ip.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import com.serotonin.io.messaging.MessageRequest;
import com.serotonin.io.messaging.MessageResponse;
import com.serotonin.modbus4j.ModbusSlave;
import com.serotonin.modbus4j.ProcessImage;
import com.serotonin.modbus4j.base.ModbusUtils;
import com.serotonin.modbus4j.exception.ModbusInitException;
import com.serotonin.modbus4j.ip.IpMessageParser;
import com.serotonin.modbus4j.ip.IpRequestHandler;
import com.serotonin.util.queue.ByteQueue;

public class UdpSlave extends ModbusSlave {
    // Configuration fields
    private int port = ModbusUtils.TCP_PORT;

    // Runtime fields.
    private DatagramSocket datagramSocket;
    private ExecutorService executorService;
    private IpMessageParser messageParser = new IpMessageParser();
    private IpRequestHandler requestHandler;
    
    public UdpSlave(ProcessImage processImage, int slaveId) {
        super(processImage, slaveId);
        requestHandler = new IpRequestHandler(slaveId, processImage);
        executorService = Executors.newCachedThreadPool();
    }

    public void setPort(int port) {
        this.port = port;
    }
    
    public void start() throws ModbusInitException {
        try {
            datagramSocket = new DatagramSocket(port);
            
            DatagramPacket datagramPacket;
            while (true) {
                datagramPacket = new DatagramPacket(new byte[1028], 1028); 
                datagramSocket.receive(datagramPacket);
                
                UdpConnectionHandler handler = new UdpConnectionHandler(datagramPacket);
                executorService.execute(handler);
            }
        }
        catch (IOException e) {
            throw new ModbusInitException(e);
        }
    }

    public void stop() {
        // Close the socket first to prevent new messages.
        datagramSocket.close();
        
        // Close the executor service.
        executorService.shutdown();
        try {
            executorService.awaitTermination(3, TimeUnit.SECONDS);
        }
        catch (InterruptedException e) {
            getExceptionListener().receivedException(e);
        }
    }
    
    class UdpConnectionHandler implements Runnable {
        private DatagramPacket requestPacket;
        
        UdpConnectionHandler(DatagramPacket requestPacket) throws ModbusInitException {
            this.requestPacket = requestPacket;
        }
        
        public void run() {
            try {
                ByteQueue requestQueue = new ByteQueue(requestPacket.getData(), 0, requestPacket.getLength());
                
                // Parse the request data and get the response.
                MessageRequest request = messageParser.parseRequest(requestQueue);
                MessageResponse response = requestHandler.handleRequest(request);
                
                if (response == null)
                    return;
                
                // Create a response packet.
                byte[] responseData = response.getMessageData();
                DatagramPacket responsePacket = new DatagramPacket(responseData, responseData.length,
                        requestPacket.getAddress(), requestPacket.getPort());
            
                // Send the response back.
                datagramSocket.send(responsePacket);
            }
            catch (Exception e) {
                getExceptionListener().receivedException(e);
            }
        }
    }
}
