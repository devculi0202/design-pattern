/*
 * SingletonRunner.java
 *
 * Copyright by CRIF AG
 * Zürich
 * All rights reserved.
 */
package com.devculi.designpattern.creationals.singleton.multiplethread;

/**
 *
 *
 * @author ltduy
 * @version $Revision:  $
 */
public class SingletonRunner implements Runnable
{

    /**
     * @see java.lang.Runnable#run()
     */
    @Override
    public void run()
    {
        Singleton singletonRun = Singleton.getInstance();
        System.out.println("singletonRun hashcode "+singletonRun.hashCode());
    }

}


/*
 * Changes:
 * $Log: $
 */