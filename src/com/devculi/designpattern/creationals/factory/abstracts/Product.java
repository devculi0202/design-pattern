/*
 * Product.java
 */
package com.devculi.designpattern.creationals.factory.abstracts;

/**
 * @author devculi
 */
public abstract class Product
{
    protected String name;

    /**
     * Gets the name
     *
     * @return Returns the name
     */
    public String getName()
    {
        return name;
    }

    /**
     * Sets the name
     *
     * @param name The name to set
     */
    public void setName(String name)
    {
        this.name = name;
    }
}
