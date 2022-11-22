/*
 * SingletonFixReflection.java
 *
 * Copyright by CRIF AG
 * Zürich
 * All rights reserved.
 */
package com.devculi.designpattern.creationals.singleton.fix;


/**
 *
 *
 * @author ltduy
 * @version $Revision:  $
 */
public class SingletonFixViolation implements Cloneable
{
    private static SingletonFixViolation uniqueInstance = null;
    private SingletonFixViolation() {
        if (uniqueInstance != null)
        {
            throw new RuntimeException("Can't create instance. Please use getInsance() to create it.");
        }
    }

    /**
     * @see java.lang.Object#clone()
     */
    @Override
    protected Object clone() throws CloneNotSupportedException
    {
        if (uniqueInstance != null)
        {
            throw new CloneNotSupportedException("Can't create instance. Please use getInsance() to create it.");
        }
        return super.clone();
    }

    public static SingletonFixViolation getInstance()
    {
        if (uniqueInstance == null) {
            uniqueInstance = new SingletonFixViolation();
        }
        return uniqueInstance;
    }
}


/*
 * Changes:
 * $Log: $
 */