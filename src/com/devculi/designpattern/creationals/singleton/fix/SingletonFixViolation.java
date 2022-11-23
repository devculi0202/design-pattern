/*
 * SingletonFixViolation.java
 *
 * Copyright by CRIF AG
 * Zürich
 * All rights reserved.
 */
package com.devculi.designpattern.creationals.singleton.fix;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

/**
 *
 *
 * @author ltduy
 * @version $Revision:  $
 */
public interface SingletonFixViolation
{
  void fix() throws CloneNotSupportedException, FileNotFoundException, IOException, ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
}


/*
 * Changes:
 * $Log: $
 */