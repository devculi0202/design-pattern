/*
 * SingletonBean.java
 *
 * Copyright by CRIF AG
 * Zürich
 * All rights reserved.
 */
package com.devculi.designpattern.creationals.singleton.multiplethread;

import java.io.Serializable;

/**
 *
 *
 * @author ltduy
 * @version $Revision:  $
 */
public class SingletonRun implements Cloneable, Serializable
{
    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    private static SingletonRun uniqueInstance = null;
    private SingletonRun() {
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

    public static SingletonRun getInstance()
    {
        if (uniqueInstance == null) {
            uniqueInstance = new SingletonRun();
        }
        return uniqueInstance;
    }

    private Object readResolve() {
        return SingletonRun.getInstance();
    }


    public static void run()
    {
        SingletonRun singletonRun = SingletonRun.getInstance();
        System.out.println("singletonRun hashcode" + singletonRun.hashCode());
    }



}


/*
 * Changes:
 * $Log: $
 */