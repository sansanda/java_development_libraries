/*
 * $Id: QuantityFormat.java, v 0.1
 *
 * The contents of this file are subject to the Mozilla Public License Version
 * 1.1; you may not use this file except in compliance with the License. You may
 * obtain a copy of the License at http://www.mozilla.org/MPL/
 *
 * Software distributed under the License is distributed on an "AS IS" basis,
 * WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for
 * the specific language governing rights and limitations under the License.
 *
 * The Original Code is QuantityFormat.java
 *
 * The Initial Developer of the Original Code is PC Automation.
 * Portions created by PC Automation are Copyright (C) 2003.
 * All Rights Reserved.
 *
 * Contributor(s):
 *
 */

package com.pcauto.util;

/** <CODE>QuantityFormat</CODE>  provides common function to be used by its subclasses
 * @author $Author: genec $
 * @version $Revision: 1.3 $
 */
public abstract class QuantityFormat extends java.text.Format{
    
    /**
     * Returns true if grouping is used in this format. For example, in the
     * English locale, with grouping on, the number 1234567 might be formatted
     * as "1,234,567". The grouping separator as well as the size of each group
     * is locale dependant.
     * @see #setGroupingUsed
     * @return <CODE>boolean</CODE> grouping value
     */
    public boolean isGroupingUsed() {
        return groupingUsed;
    }
    
    /**
     * Set whether or not grouping will be used in this format.
     * @see #isGroupingUsed
     * @param <CODE>boolean</CODE> grouping value
     */
    public void setGroupingUsed(boolean newValue) {
        groupingUsed = newValue;
    }
    
    /** Sets scale for use in <CODE>format</CODE> method.
     *
     * @param <CODE>int</CODE> scale
     */
    public void setScale(int scale){
        if (scale < 0) {
            System.out.println("QuantityFormat: Error: Attempt to set invalid scale. Using default: 2");
            return;
        }
        this.scale = scale;
    }
    
    /** Returns <CODE>int</CODE> value of scale.
     *
     * @return <CODE>int</CODE> value current scale
     */
    public int getScale(){
        return scale;
    }

    protected int scale=2;
    protected boolean groupingUsed = false;
    protected Units units;
    
}

