package com.devculi;

import java.io.IOException;

import com.devculi.application.DependenceInjectionApplication;
import com.devculi.dependence.injection.framwork.annotations.CustomApplication;

@CustomApplication
public class DesignPatternApplication
{
    public static void main(String[] args) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException
    {
        DependenceInjectionApplication.run(DesignPatternApplication.class, args);
    }
}
