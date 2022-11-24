/*
 * ClientHandler.java
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
 * @version $Revision: $
 */

/*
 * Refer from package org.apache.poi.ss.usermodel.WorkbookFactory;
 */
public class ClientHandler
{
    public static void main(String[] args) throws Exception
    {
      Product product1 =  AbstractFactory.create("com.devculi.designpattern.creationals.factory.abstracts.Product1Factory");
      System.out.println(product1.getName());

      Product product2 =  AbstractFactory.create("com.devculi.designpattern.creationals.factory.abstracts.Product2Factory");
      System.out.println(product2.getName());
    }
}

/*
 * Changes: $Log: $
 */