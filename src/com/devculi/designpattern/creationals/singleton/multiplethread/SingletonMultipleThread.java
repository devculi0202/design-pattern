/*
 * SingletonMultipleThread.java
 *
 * Copyright by CRIF AG
 * Zürich
 * All rights reserved.
 */
package com.devculi.designpattern.creationals.singleton.multiplethread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 *
 * @author ltduy
 * @version $Revision:  $
 */
public class SingletonMultipleThread
{
    public static void main(String[] args)
    {
        ExecutorService excutorService = Executors.newFixedThreadPool(3);
        excutorService.execute(new Runnable()
        {
            @Override
            public void run()
            {
               SingletonRun singletonRun = SingletonRun.getInstance();
               System.out.println("singletonRun hashcode"+singletonRun.hashCode());
            }
        });

        excutorService.execute(new Runnable()
        {
            @Override
            public void run()
            {
               SingletonRun singletonRun = SingletonRun.getInstance();
               System.out.println("singletonRun hashcode" + singletonRun.hashCode());
            }
        });

        excutorService.shutdown();

    }

}


/*
 * Changes:
 * $Log: $
 */