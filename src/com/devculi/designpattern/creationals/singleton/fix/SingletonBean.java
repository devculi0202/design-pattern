/*
 * SingletonBean.java
 *
 * Copyright by CRIF AG
 * Zürich
 * All rights reserved.
 */
package com.devculi.designpattern.creationals.singleton.fix;

import java.io.Serializable;

/**
 *
 *
 * @author ltduy
 * @version $Revision:  $
 */
public class SingletonBean implements Cloneable, Serializable
{
    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    private static SingletonBean uniqueInstance = null;
    private SingletonBean() {
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

    public static SingletonBean getInstance()
    {
        if (uniqueInstance == null) {
            uniqueInstance = new SingletonBean();
        }
        return uniqueInstance;
    }

    private Object readResolve() {
        return SingletonBean.getInstance();
    }


}


/*
 * Changes:
 * $Log: $
 */