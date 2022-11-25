/*
 * AbstractFactory.java
 *
 */
package com.devculi.designpattern.creationals.factory.abstracts;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author devculi
 */
public abstract class AbstractFactory
{
    private static Logger logger = Logger.getLogger(AbstractFactory.class.getName());

    public static Product create(String factoryClass) throws Exception
    {
            logger.log(Level.INFO, "Create product from " + factoryClass);
            return FactoryFinder.createProduct(factoryClass);
    }
    protected abstract Product createProduct();
}
