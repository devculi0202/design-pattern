/*
 * SingletonFixRelfection.java
 */
package com.devculi.designpattern.creationals.singleton.fix;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author devculi
 */
public class SingletonFixRelfection implements SingletonFixViolation
{

    /**
     * @throws SecurityException
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     * @throws IllegalArgumentException
     * @throws IllegalAccessException
     * @throws InstantiationException
     * @see com.devculi.designpattern.creationals.singleton.fix.SingletonFixViolation#fix()
     */
    @Override
    public void fix() throws FileNotFoundException, IOException, ClassNotFoundException, CloneNotSupportedException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException
    {
        SingletonBean singleton1 = SingletonBean.getInstance();
        SingletonBean singleton2 = SingletonBean.getInstance();

        System.out.println("instance1 hashcode " + singleton1.hashCode());
        System.out.println("instance2 hashcode " + singleton2.hashCode());

        Constructor<SingletonBean> constructor =  SingletonBean.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        SingletonBean singletonUseReflection =  constructor.newInstance();
        System.out.println("singletonUseReflection hashcode " + singletonUseReflection.hashCode());
    }

}
