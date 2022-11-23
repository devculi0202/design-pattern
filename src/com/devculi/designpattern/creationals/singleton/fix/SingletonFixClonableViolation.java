/*
 * SingletonFixClonableViolation.java
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
public class SingletonFixClonableViolation implements SingletonFixViolation
{

    /**
     * @throws CloneNotSupportedException
     * @see com.devculi.designpattern.creationals.singleton.fix.SingletonFixViolation#fix()
     */
    @Override
    public void fix() throws CloneNotSupportedException
    {
        SingletonBean singleton1 = SingletonBean.getInstance();
        SingletonBean singleton2 = SingletonBean.getInstance();

        System.out.println("instance1 hashcode " + singleton1.hashCode());
        System.out.println("instance2 hashcode " + singleton2.hashCode());

        //fix singleton violation use clonable
        SingletonBean singletonUseClonable =  (SingletonBean) singleton1.clone();
        System.out.println("singletonUseClonable hashcode " + singletonUseClonable.hashCode());
    }

}


/*
 * Changes:
 * $Log: $
 */