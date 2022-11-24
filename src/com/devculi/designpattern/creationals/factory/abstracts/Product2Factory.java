/*
 * Product2Factory.java
 *
 * Copyright by CRIF AG
 * Zürich
 * All rights reserved.
 */
package com.devculi.designpattern.creationals.factory.abstracts;

/**
 *
 *
 * @author ltduy
 * @version $Revision:  $
 */
public class Product2Factory extends AbstractFactory
{
   /**
     * @see com.devculi.designpattern.creationals.factory.abstracts.AbstractFactory#createProduct()
     */
    @Override
    protected Product createProduct()
    {
        return new ConcreteProduct2();
    }
}


/*
 * Changes:
 * $Log: $
 */