package com.serotonin.modbus4j.serial;

import gnu.io.SerialPort;

import com.serotonin.io.messaging.StreamTransport;
import com.serotonin.io.serial.SerialParameters;
import com.serotonin.io.serial.SerialUtils;
import com.serotonin.modbus4j.ModbusMaster;
import com.serotonin.modbus4j.exception.ModbusInitException;

abstract public class SerialMaster extends ModbusMaster {
    //
    // Configuration fields.
    private final SerialParameters serialParameters;
    
    // Runtime fields.
    protected SerialPort serialPort;
    protected StreamTransport transport;
    
    
    public SerialMaster(SerialParameters params) {
        serialParameters = params;
    }
    
    @Override
    public void init() throws ModbusInitException {
        try {
            serialPort = SerialUtils.openSerialPort(serialParameters);
            transport = new StreamTransport(serialPort.getInputStream(), serialPort.getOutputStream(),
                    "Modbus4J SerialMaster");
        }
        catch (Exception e) {
            throw new ModbusInitException(e);
        }
    }

    public void close() {
        SerialUtils.close(serialPort);
    }
}
