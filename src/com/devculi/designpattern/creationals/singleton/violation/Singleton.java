package com.devculi.designpattern.creationals.singleton.violation;

import java.io.Serializable;

public class Singleton implements Cloneable, Serializable
{
    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    private static Singleton uniqueInstance = null;
    private Singleton() {
    }

    /**
     * @see java.lang.Object#clone()
     */
    @Override
    public Object clone() throws CloneNotSupportedException
    {
        return super.clone();
    }

    public static Singleton getInstance()
    {
        if (uniqueInstance == null) {
            uniqueInstance = new Singleton();
        }
        return uniqueInstance;
    }

}
