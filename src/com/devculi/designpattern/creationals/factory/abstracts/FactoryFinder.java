/*
 * FactoryFinder.java
 */
package com.devculi.designpattern.creationals.factory.abstracts;

import java.lang.reflect.Method;

/**
 * @author devculi
 */
class FactoryFinder
{
    static Product find(String factoryClass) throws Exception
    {
        try
        {
            Class<?> clazz = AbstractFactory.class.getClassLoader().loadClass(factoryClass);
            Method method = clazz.getDeclaredMethod("createProduct");
            return (Product) method.invoke(clazz.newInstance());
        }
        catch (Exception e)
        {
            throw new Exception("Cann't create product "+ e.getMessage());
        }
    }
}
