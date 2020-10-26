package com.serotonin.modbus4j.serial.rtu;

import java.io.IOException;

import com.serotonin.io.messaging.SenderConnection;
import com.serotonin.io.serial.SerialParameters;
import com.serotonin.modbus4j.exception.ModbusInitException;
import com.serotonin.modbus4j.exception.ModbusTransportException;
import com.serotonin.modbus4j.msg.ModbusRequest;
import com.serotonin.modbus4j.msg.ModbusResponse;
import com.serotonin.modbus4j.serial.SerialMaster;

public class RtuMaster extends SerialMaster {
    // Configuration fields.
    private final boolean reverseCRC;
    
    // Runtime fields.
    private SenderConnection conn;
    
    public RtuMaster(SerialParameters params, boolean reverseCRC) {
        super(params);
        this.reverseCRC = reverseCRC;
    }
    
    @Override
    public void init() throws ModbusInitException {
        super.init();
        RtuMessageParser rtuMessageParser = new RtuMessageParser(reverseCRC);
        conn = getSenderConnection();
        try {
            conn.start(transport, rtuMessageParser);
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
        // Wrap the modbus request in an rtu request.
        RtuMessageRequest rtuRequest = new RtuMessageRequest(request, reverseCRC);
        
        // Send the request to get the response.
        RtuMessageResponse rtuResponse;
        try {
            rtuResponse = (RtuMessageResponse)conn.send(rtuRequest);
            return rtuResponse.getModbusResponse();
        }
        catch (Exception e) {
            throw new ModbusTransportException(e);
        }
    }
}
