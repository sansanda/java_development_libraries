package com.intelligt.modbus.jlibmodbus.serial;

import com.intelligt.modbus.jlibmodbus.Modbus;
import purejavacomm.CommPortIdentifier;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

/*
 * Copyright (C) 2017 Vladislav Y. Kochedykov
 *
 * [http://jlibmodbus.sourceforge.net]
 *
 * This file is part of JLibModbus.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Authors: Vladislav Y. Kochedykov, software engineer.
 * email: vladislav.kochedykov@gmail.com
 */
public class SerialPortFactoryPJC extends SerialPortAbstractFactory {

    public SerialPortFactoryPJC() {
        super("purejavacomm.PureJavaComm", "purejavacomm");
    }

    @Override
    public SerialPort createSerialImpl(SerialParameters sp) {
        return new SerialPortPJC(sp);
    }

    @Override
    public List<String> getPortIdentifiersImpl() {
        Enumeration ports = CommPortIdentifier.getPortIdentifiers();
        List<String> list = new ArrayList<String>();
        while (ports.hasMoreElements()) {
            CommPortIdentifier id = (CommPortIdentifier) ports.nextElement();
            if (id.getPortType() == CommPortIdentifier.PORT_SERIAL) {
                list.add(id.getName());
            }
        }
        return list;
    }

    @Override
    public String getVersion() {
        return available() ? purejavacomm.PureJavaComm.getVersion() : super.getVersion();
    }
}
