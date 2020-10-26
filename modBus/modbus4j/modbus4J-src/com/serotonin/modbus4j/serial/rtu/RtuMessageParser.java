package com.serotonin.modbus4j.serial.rtu;

import com.serotonin.io.messaging.MessageRequest;
import com.serotonin.io.messaging.MessageResponse;
import com.serotonin.modbus4j.base.BaseMessageParser;
import com.serotonin.util.queue.ByteQueue;

/**
 * Message parser implementation for RTU encoding. Primary reference for the ordering of CRC bytes. Also
 * provides handling of incomplete messages.
 * @author mlohbihler
 */
public class RtuMessageParser extends BaseMessageParser {
    private boolean reverseCRC;
    
    public RtuMessageParser(boolean reverseCRC) {
        this.reverseCRC = reverseCRC;
    }
    
    protected MessageResponse parseResponseImpl(ByteQueue queue) throws Exception {
        return RtuMessageResponse.createRtuMessageResponse(queue, reverseCRC);
    }

    protected MessageRequest parseRequestImpl(ByteQueue queue) throws Exception {
        return RtuMessageRequest.createRtuMessageRequest(queue, reverseCRC);
    }
}
