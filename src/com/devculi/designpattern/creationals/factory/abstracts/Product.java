/*
 * Product.java
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


/*
 * Changes:
 * $Log: $
 */