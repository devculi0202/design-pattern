package com.devculi.designpattern.creationals.factory.devculisolution;

public class FactoryProducer
{
    private static CourseFactory courseFactory;
    public static CourseFactory getFactory(String inputUser) {
        if (inputUser.equalsIgnoreCase("Java")) {
            courseFactory = new JavaCourseFactory();
        }
        if (inputUser.equalsIgnoreCase(".Net")) {
            courseFactory = new NetCourseFactory();
        }
        return courseFactory;
    }

}
