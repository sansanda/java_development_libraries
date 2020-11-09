package com.serotonin.modbus4j.serial.ascii;

import com.serotonin.io.messaging.MessageMismatchException;
import com.serotonin.io.messaging.MessageRequest;
import com.serotonin.io.messaging.MessageResponse;
import com.serotonin.modbus4j.exception.ModbusTransportException;
import com.serotonin.modbus4j.msg.ModbusMessage;
import com.serotonin.modbus4j.msg.ModbusRequest;
import com.serotonin.util.queue.ByteQueue;

public class AsciiMessageRequest extends AsciiMessage implements MessageRequest {
    static AsciiMessageRequest createAsciiMessageRequest(ByteQueue queue) throws ModbusTransportException {
        ByteQueue msgQueue = getUnasciiMessage(queue);
        ModbusRequest request = ModbusRequest.createModbusRequest(msgQueue);
        AsciiMessageRequest asciiRequest = new AsciiMessageRequest(request);
        
        // Return the data.
        return asciiRequest;
    }
    
    public AsciiMessageRequest(ModbusMessage modbusMessage) {
        super(modbusMessage);
    }
    
    public void isValidResponse(MessageResponse res) throws MessageMismatchException {
        if (!(res instanceof AsciiMessageResponse))
            throw new MessageMismatchException("Response is not an AsciiMessageResponse: "+ res.getClass());
        
        AsciiMessageResponse response = (AsciiMessageResponse)res;
        getModbusRequest().matches(response.getModbusResponse());
    }
    
    public ModbusRequest getModbusRequest() {
        return (ModbusRequest)modbusMessage;
    }
}
