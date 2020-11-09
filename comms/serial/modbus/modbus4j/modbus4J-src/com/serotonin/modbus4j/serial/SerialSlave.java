package com.serotonin.modbus4j.serial;

import gnu.io.SerialPort;

import com.serotonin.io.messaging.StreamTransport;
import com.serotonin.io.serial.SerialParameters;
import com.serotonin.io.serial.SerialUtils;
import com.serotonin.modbus4j.ModbusSlave;
import com.serotonin.modbus4j.ProcessImage;
import com.serotonin.modbus4j.exception.ModbusInitException;

abstract public class SerialSlave extends ModbusSlave {
    // Configuration fields.
    private final SerialParameters serialParameters;
    
    // Runtime fields
    private SerialPort serialPort;
    protected StreamTransport transport;
    
    public SerialSlave(ProcessImage processImage, int slaveId, SerialParameters params) {
        super(processImage, slaveId);
        serialParameters = params;
    }
    
    @Override
    public void start() throws ModbusInitException {
        try {
            serialPort = SerialUtils.openSerialPort(serialParameters);
            transport = new StreamTransport(serialPort.getInputStream(), serialPort.getOutputStream(),
                    "Modbus4J SerialSlave");
        }
        catch (Exception e) {
            throw new ModbusInitException(e);
        }
    }

    @Override
    public void stop() {
        SerialUtils.close(serialPort);
    }
}
