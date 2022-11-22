package com.devculi.designpattern.creationals.singleton.violation;

public class Singleton implements Cloneable
{
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
