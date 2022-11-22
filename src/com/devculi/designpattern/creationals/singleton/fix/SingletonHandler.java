package com.devculi.designpattern.creationals.singleton.fix;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;


public class SingletonHandler
{
    public static void main(String[] args) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, CloneNotSupportedException
    {

        SingletonFixViolation singleton1 = SingletonFixViolation.getInstance();
        SingletonFixViolation singleton2 = SingletonFixViolation.getInstance();

        System.out.println("instance1 hashcode " + singleton1.hashCode());
        System.out.println("instance2 hashcode " + singleton2.hashCode());

        //Fix singleton violation through reflect.
        Constructor<SingletonFixViolation> constructor =  SingletonFixViolation.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        SingletonFixViolation signletonUseReflect = constructor.newInstance();
        System.out.println("signletonUseReflect hashcode " + signletonUseReflect.hashCode());

        //Fix singleton violation through clone
        SingletonFixViolation singletonFixClonable  = (SingletonFixViolation)singleton2.clone();
        System.out.println("singletonFixClonable hashcode " + singletonFixClonable.hashCode());


    }

}
