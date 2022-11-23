package com.devculi.designpattern.creationals.singleton.fix;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class SingletonHandler
{
    public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException, IOException, CloneNotSupportedException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException
    {
        SingletonFixViolation singletonFixSerializable = SingletonFixViolationFactory.getFixViolation(ViolationType.SERIALIZABLE);
        singletonFixSerializable.fix();

        SingletonFixViolation singletonFixClonable = SingletonFixViolationFactory.getFixViolation(ViolationType.CLONABLE);
        singletonFixClonable.fix();

        SingletonFixViolation singletonFixReflection = SingletonFixViolationFactory.getFixViolation(ViolationType.REFLECT);
        singletonFixReflection.fix();

    }

}
