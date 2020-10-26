/*
 * Units.java
 *
 * Created on December 11, 2003, 10:10 AM
 */

package com.pcauto.util;

/**
 *
 * @author  genec
 */
public abstract class Units implements java.io.Serializable {
    
    public int getId() {
        return id;
    }
    
    public String getString() {
        return str;
    }
    
    public String getDesc() {
        return desc;
    }
    
    public String toString() {
        return getDesc();
    }
    
    public abstract Units[] getAll();
    
    public abstract double convertFrom(double value, Units srcUnits);
    
    /** Creates a new instance of Units */
    protected Units(String str, String desc) {
        this.str = str;
        this.desc = desc;
    }
    
    protected String str;
    protected String desc;
    protected int id;
    
}
