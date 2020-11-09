/*
 * Created on 28-Sep-2006
 */
package com.serotonin.modbus4j.serial.ascii;

import java.io.IOException;

import com.serotonin.io.messaging.ListenerConnection;
import com.serotonin.io.serial.SerialParameters;
import com.serotonin.modbus4j.ProcessImage;
import com.serotonin.modbus4j.exception.ModbusInitException;
import com.serotonin.modbus4j.serial.SerialSlave;
    
public class AsciiSlave extends SerialSlave {
    private ListenerConnection conn;

    public AsciiSlave(ProcessImage processImage, int slaveId, SerialParameters params) {
        super(processImage, slaveId, params);
    }
    
    public void start() throws ModbusInitException {
        super.start();
        
        AsciiMessageParser asciiMessageParser = new AsciiMessageParser();
        AsciiRequestHandler asciiRequestHandler = new AsciiRequestHandler(slaveId, processImage);
        
        conn = new ListenerConnection(asciiRequestHandler);
        conn.addListener(getExceptionListener());
        
        try {
            conn.start(transport, asciiMessageParser);
        }
        catch (IOException e) {
            throw new ModbusInitException(e);
        }
    }

    public void stop() {
        conn.close();
        super.stop();
    }
}
