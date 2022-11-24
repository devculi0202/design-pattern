/*
 * AbstractFactory.java
 *
 * Copyright by CRIF AG
 * Zürich
 * All rights reserved.
 */
package com.devculi.designpattern.creationals.factory.abstracts;

import java.lang.reflect.Method;
import java.util.logging.Logger;

/**
 *
 *
 * @author ltduy
 * @version $Revision: $
 */
public abstract class AbstractFactory
{
    private static Logger logger = Logger.getLogger(AbstractFactory.class.getName());

    public static Product create(String factoryClass) throws Exception
    {
            return createProduct(factoryClass);
    }

    protected abstract Product createProduct();

    private static Product createProduct(String factoryClass) throws Exception
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

/*
 * Changes: $Log: $
 */