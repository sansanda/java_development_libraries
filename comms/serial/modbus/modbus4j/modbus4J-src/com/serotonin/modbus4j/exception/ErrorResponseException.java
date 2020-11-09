package com.serotonin.modbus4j.exception;

import com.serotonin.modbus4j.msg.ModbusRequest;
import com.serotonin.modbus4j.msg.ModbusResponse;

public class ErrorResponseException extends Exception {
    private static final long serialVersionUID = -1;

    private ModbusRequest originalRequest;
    private ModbusResponse errorResponse;
    
    public ErrorResponseException(ModbusRequest originalRequest, ModbusResponse errorResponse) {
        this.originalRequest = originalRequest;
        this.errorResponse = errorResponse;
    }

    public ModbusResponse getErrorResponse() {
        return errorResponse;
    }

    public ModbusRequest getOriginalRequest() {
        return originalRequest;
    }
}
