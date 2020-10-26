package com.serotonin.modbus4j.serial.rtu;

import com.serotonin.io.messaging.MessageRequest;
import com.serotonin.io.messaging.MessageResponse;
import com.serotonin.modbus4j.ProcessImage;
import com.serotonin.modbus4j.base.BaseRequestHandler;
import com.serotonin.modbus4j.msg.ModbusRequest;
import com.serotonin.modbus4j.msg.ModbusResponse;

public class RtuRequestHandler extends BaseRequestHandler {
    public RtuRequestHandler(int slaveId, ProcessImage processImage) {
        super(slaveId, processImage);
    }
    
    public MessageResponse handleRequest(MessageRequest req) throws Exception {
        RtuMessageRequest rtuRequest = (RtuMessageRequest)req;
        ModbusRequest request = rtuRequest.getModbusRequest();
        
        if (!checkSlaveId(request))
            return null;
            
        ModbusResponse response = request.handle(processImage);
        return new RtuMessageResponse(response, rtuRequest.isReverseCRC());
    }
}
