package com.serotonin.modbus4j.serial.ascii;

import com.serotonin.io.messaging.MessageRequest;
import com.serotonin.io.messaging.MessageResponse;
import com.serotonin.modbus4j.base.BaseMessageParser;
import com.serotonin.util.queue.ByteQueue;

public class AsciiMessageParser extends BaseMessageParser {
    protected MessageResponse parseResponseImpl(ByteQueue queue) throws Exception {
        return AsciiMessageResponse.createAsciiMessageResponse(queue);
    }

    protected MessageRequest parseRequestImpl(ByteQueue queue) throws Exception {
        return AsciiMessageRequest.createAsciiMessageRequest(queue);
    }
}
