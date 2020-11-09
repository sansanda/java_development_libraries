package com.serotonin.modbus4j.serial.ascii;

import com.serotonin.io.messaging.MessageResponse;
import com.serotonin.modbus4j.exception.ModbusTransportException;
import com.serotonin.modbus4j.msg.ModbusMessage;
import com.serotonin.modbus4j.msg.ModbusResponse;
import com.serotonin.util.queue.ByteQueue;

public class AsciiMessageResponse extends AsciiMessage implements MessageResponse {
    static AsciiMessageResponse createAsciiMessageResponse(ByteQueue queue) throws ModbusTransportException {
        ByteQueue msgQueue = getUnasciiMessage(queue);
        ModbusResponse response = ModbusResponse.createModbusResponse(msgQueue);
        AsciiMessageResponse asciiResponse = new AsciiMessageResponse(response);
        
        // Return the data.
        return asciiResponse;
    }
    
    public AsciiMessageResponse(ModbusMessage modbusMessage) {
        super(modbusMessage);
    }
    
    public ModbusResponse getModbusResponse() {
        return (ModbusResponse)modbusMessage;
    }
}
