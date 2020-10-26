package com.serotonin.modbus4j.serial.ascii;

import java.io.IOException;

import com.serotonin.io.messaging.SenderConnection;
import com.serotonin.io.serial.SerialParameters;
import com.serotonin.modbus4j.exception.ModbusInitException;
import com.serotonin.modbus4j.exception.ModbusTransportException;
import com.serotonin.modbus4j.msg.ModbusRequest;
import com.serotonin.modbus4j.msg.ModbusResponse;
import com.serotonin.modbus4j.serial.SerialMaster;

public class AsciiMaster extends SerialMaster {
    private SenderConnection conn;
    
    public AsciiMaster(SerialParameters params) {
        super(params);
    }
    
    @Override
    public void init() throws ModbusInitException {
        super.init();
        AsciiMessageParser asciiMessageParser = new AsciiMessageParser();
        conn = getSenderConnection();
        try {
            conn.start(transport, asciiMessageParser);
        }
        catch (IOException e) {
            throw new ModbusInitException(e);
        }
        initialized = true;
    }

    @Override
    public void destroy() {
        closeSenderConnection(conn);
        super.close();
    }

    @Override
    public ModbusResponse send(ModbusRequest request) throws ModbusTransportException {
        // Wrap the modbus request in an ascii request.
        AsciiMessageRequest asciiRequest = new AsciiMessageRequest(request);
        
        // Send the request to get the response.
        AsciiMessageResponse asciiResponse;
        try {
            asciiResponse = (AsciiMessageResponse)conn.send(asciiRequest);
            return asciiResponse.getModbusResponse();
        }
        catch (Exception e) {
            throw new ModbusTransportException(e);
        }
    }
}
