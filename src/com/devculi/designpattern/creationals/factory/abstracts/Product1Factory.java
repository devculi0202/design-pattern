/*
 * Product1Factory.java
 */
package com.devculi.designpattern.creationals.factory.abstracts;

/**
 * @author devculi
 */
public class Product1Factory extends AbstractFactory
{
    /**
     * @see com.devculi.designpattern.creationals.factory.abstracts.AbstractFactory#createProduct()
     */
    @Override
    protected Product createProduct()
    {
        return new ConcreteProduct1();
    }
}
