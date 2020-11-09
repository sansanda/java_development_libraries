package com.serotonin.modbus4j.serial.ascii;

import com.serotonin.io.messaging.MessageRequest;
import com.serotonin.io.messaging.MessageResponse;
import com.serotonin.modbus4j.ProcessImage;
import com.serotonin.modbus4j.base.BaseRequestHandler;
import com.serotonin.modbus4j.msg.ModbusRequest;
import com.serotonin.modbus4j.msg.ModbusResponse;

public class AsciiRequestHandler extends BaseRequestHandler {
    public AsciiRequestHandler(int slaveId, ProcessImage processImage) {
        super(slaveId, processImage);
    }
    
    public MessageResponse handleRequest(MessageRequest req) throws Exception {
        AsciiMessageRequest asciiRequest = (AsciiMessageRequest)req;
        ModbusRequest request = asciiRequest.getModbusRequest();
        
        if (!checkSlaveId(request))
            return null;
            
        ModbusResponse response = request.handle(processImage);
        return new AsciiMessageResponse(response);
    }
}
