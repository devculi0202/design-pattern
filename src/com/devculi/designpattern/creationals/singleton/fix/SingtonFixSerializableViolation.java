package com.devculi.designpattern.creationals.singleton.fix;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 *
 * @author ltduy
 * @version $Revision:  $
 */
public class SingtonFixSerializableViolation implements SingletonFixViolation
{

    /**
     * @throws IOException
     * @throws FileNotFoundException
     * @throws ClassNotFoundException
     * @see com.devculi.designpattern.creationals.singleton.fix.SingletonFixViolation#fix()
     */
    @Override
    public void fix() throws FileNotFoundException, IOException, ClassNotFoundException
    {
        SingletonBean singleton1 = SingletonBean.getInstance();
        SingletonBean singleton2 = SingletonBean.getInstance();

        System.out.println("instance1 hashcode " + singleton1.hashCode());
        System.out.println("instance2 hashcode " + singleton2.hashCode());
        //Fix singleton violation through serializable
        // use serializable
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(new File("C:\\Users\\ltduy\\Desktop\\singleton1.txt")));
        objectOutputStream.writeObject(singleton1);

        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(new File("C:\\Users\\ltduy\\Desktop\\singleton1.txt")));
        SingletonBean singletonUseSerializable = (SingletonBean)objectInputStream.readObject();
        System.out.println("singletonUseSerializable hashcode " + singletonUseSerializable.hashCode());
    }

}


/*
 * Changes:
 * $Log: $
 */