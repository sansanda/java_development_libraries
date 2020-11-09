package com.serotonin.modbus4j.serial.rtu;

import com.serotonin.io.messaging.MessageResponse;
import com.serotonin.modbus4j.exception.ModbusTransportException;
import com.serotonin.modbus4j.msg.ModbusResponse;
import com.serotonin.util.queue.ByteQueue;

/**
 * Handles the RTU enveloping of modbus responses.
 * @author mlohbihler
 */
public class RtuMessageResponse extends RtuMessage implements MessageResponse {
    static RtuMessageResponse createRtuMessageResponse(ByteQueue queue, boolean reverseCRC)
            throws ModbusTransportException {
        ModbusResponse response = ModbusResponse.createModbusResponse(queue);
        RtuMessageResponse rtuResponse = new RtuMessageResponse(response, reverseCRC);
        
        // Check the CRC
        rtuResponse.checkCRC(queue);
        
        // Return the data.
        return rtuResponse;
    }
    
    public RtuMessageResponse(ModbusResponse modbusResponse, boolean reverseCRC) {
        super(modbusResponse, reverseCRC);
    }
    
    public ModbusResponse getModbusResponse() {
        return (ModbusResponse)modbusMessage;
    }
}
