/*
 * SingletonMultipleThread.java
 */
package com.devculi.designpattern.creationals.singleton.multiplethread;

import java.util.Date;

/**
 * @author devculi
 */
public class SingletonMultipleThread
{
    public static void main(String[] args)
    {
        SingletonRunner runner = new SingletonRunner();
        for(int index = 0; index < 3; index++) {
            long startTime =  System.currentTimeMillis();
            System.out.println("Start at " + new Date(startTime));
            Thread thread = new Thread(runner);
            System.out.println("Thread id "+ thread.getId() + " with name " +  thread.getName());
            thread.start();
        }
    }

}


/*
 * Changes:
 * $Log: $
 */