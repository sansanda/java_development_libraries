package com.serotonin.modbus4j.serial.rtu;

import com.serotonin.io.messaging.MessageMismatchException;
import com.serotonin.io.messaging.MessageRequest;
import com.serotonin.io.messaging.MessageResponse;
import com.serotonin.modbus4j.exception.ModbusTransportException;
import com.serotonin.modbus4j.msg.ModbusRequest;
import com.serotonin.util.queue.ByteQueue;

/**
 * Handles the RTU enveloping of modbus requests.
 * @author mlohbihler
 */
public class RtuMessageRequest extends RtuMessage implements MessageRequest {
    static RtuMessageRequest createRtuMessageRequest(ByteQueue queue, boolean reverseCRC)
            throws ModbusTransportException {
        ModbusRequest request = ModbusRequest.createModbusRequest(queue);
        RtuMessageRequest rtuRequest = new RtuMessageRequest(request, reverseCRC);
        
        // Check the CRC
        rtuRequest.checkCRC(queue);
        
        // Return the data.
        return rtuRequest;
    }
    
    public RtuMessageRequest(ModbusRequest modbusRequest, boolean reverseCRC) {
        super(modbusRequest, reverseCRC);
    }
    
    public void isValidResponse(MessageResponse res) throws MessageMismatchException {
        if (!(res instanceof RtuMessageResponse))
            throw new MessageMismatchException("Response is not an RtuMessageResponse: "+ res.getClass());
        
        RtuMessageResponse response = (RtuMessageResponse)res;
        getModbusRequest().matches(response.getModbusResponse());
    }
    
    public ModbusRequest getModbusRequest() {
        return (ModbusRequest)modbusMessage;
    }
}
