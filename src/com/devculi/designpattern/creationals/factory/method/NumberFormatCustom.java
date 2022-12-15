/*
 * NumberFormatCustom.java
 */
package com.devculi.designpattern.creationals.factory.method;

/**
 * @author devculi
 */
/*
 * This class provides the interface for formatting and parsing numbers.
 */

public abstract class NumberFormatCustom
{
    protected abstract Number parse(String source);

    public final static NumberFormatCustom getInstance() {
        return null;
    }

}
