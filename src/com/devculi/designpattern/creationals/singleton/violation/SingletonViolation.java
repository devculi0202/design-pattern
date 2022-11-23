package com.devculi.designpattern.creationals.singleton.violation;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/*1.Use Reflection to destroy singleton pattern.
 * 1.1 How to destroy
 * - We use reflect to set constructor from private to public and create new instance
 * 1.2 How to fix it
 * - Throw Runtime exception if someone tries to make instance.
 *2 Use clone() to destroy singleton pattern.
 * 2.1 How to destroy
 * - implement interface Clonable and override method clone()
 * - create new object by method clone
 * 2.2 How to fix
 * - Throw CloneNotSupportedException exception at method clone()  when singleton instance variable not null .
 * */
public class SingletonViolation
{
    public static void main(String[] args)
            throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, CloneNotSupportedException, FileNotFoundException, IOException, ClassNotFoundException
    {
        Singleton singleton1 = Singleton.getInstance();
        Singleton singleton2 = Singleton.getInstance();
        System.out.println("singleton1 hashcode " + singleton1.hashCode());
        System.out.println("singleton2 hashcode " + singleton2.hashCode());

        // use reflect
        Constructor<Singleton> constructor = Singleton.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        Singleton singletonUseReflect = constructor.newInstance();
        System.out.println("singletonUseReflect hashcode " + singletonUseReflect.hashCode());

        // use clone()
        Singleton singletonUseClone = (Singleton) singleton2.clone();
        System.out.println("singletonUseClone hashcode " + singletonUseClone.hashCode());

        // use serializable
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(new File("C:\\Users\\ltduy\\Desktop\\singleton1.txt")));
        objectOutputStream.writeObject(singleton1);

        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(new File("C:\\Users\\ltduy\\Desktop\\singleton1.txt")));
        Singleton singletonUseSerializable = (Singleton)objectInputStream.readObject();
        System.out.println("singletonUseSerializable hashcode " + singletonUseSerializable.hashCode());
    }



}
