/*
 * Created on 28-Sep-2006
 */
package com.serotonin.modbus4j.serial.rtu;

import java.io.IOException;

import com.serotonin.io.messaging.ListenerConnection;
import com.serotonin.io.serial.SerialParameters;
import com.serotonin.modbus4j.ProcessImage;
import com.serotonin.modbus4j.exception.ModbusInitException;
import com.serotonin.modbus4j.serial.SerialSlave;

public class RtuSlave extends SerialSlave {
    // Configuration fields.
    private boolean reverseCRC;
    
    // Runtime fields
    private ListenerConnection conn;

    public RtuSlave(ProcessImage processImage, int slaveId, SerialParameters params, boolean reverseCRC) {
        super(processImage, slaveId, params);
        this.reverseCRC = reverseCRC;
    }

    public void start() throws ModbusInitException {
        super.start();
        
        RtuMessageParser rtuMessageParser = new RtuMessageParser(reverseCRC);
        RtuRequestHandler rtuRequestHandler = new RtuRequestHandler(slaveId, processImage);
        
        conn = new ListenerConnection(rtuRequestHandler);
        conn.addListener(getExceptionListener());
        
        try {
            conn.start(transport, rtuMessageParser);
        }
        catch (IOException e) {
            throw new ModbusInitException(e);
        }
    }

    public void stop() {
        conn.close();
        super.stop();
    }
}
