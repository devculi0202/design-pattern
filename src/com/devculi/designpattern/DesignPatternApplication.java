package com.devculi.designpattern;

import java.io.IOException;

import com.devculi.designpattern.injector.CustomInjector;

public class DesignPatternApplication
{
    public static void main(String[] args) throws IOException, ClassNotFoundException
    {
        CustomInjector.startApplication(DesignPatternApplication.class);
    }
}
