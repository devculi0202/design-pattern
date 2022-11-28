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
public class Singleton implements Cloneable, Serializable
{
    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    private static Singleton uniqueInstance = null;
    private Singleton() {
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

    public static  Singleton getInstance()
    {
        if (uniqueInstance == null) {
            synchronized (Singleton.class)
            {
                if (uniqueInstance == null) {
                uniqueInstance = new Singleton();
                }
            }
        }
        return uniqueInstance;
    }

    private Object readResolve() {
        return Singleton.getInstance();
    }


    public static void run()
    {
        Singleton singletonRun = Singleton.getInstance();
        System.out.println("singletonRun hashcode" + singletonRun.hashCode());
    }



}


/*
 * Changes:
 * $Log: $
 */