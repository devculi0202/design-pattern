package com.devculi.designpattern.creationals.factory.devculisolution;

import com.devculi.designpattern.creationals.factory.bean.Client;
import com.devculi.designpattern.creationals.factory.bean.Course;

public class ClientApplicationWithDevculiSolution
{
    private static CourseFactory courseFactory;
    public static void main(String[] args)
    {
        Client client = new Client();
        courseFactory = FactoryProducer.getFactory(client.chooseOption("Java"));
        Course course = courseFactory.getCourse();
        course.createCourseDetail();
        course.createCourseSchedule();
    }
}

/*
 * Hmm it seems cannot resolve the bulge problem and modification problem at method getFactory() class FactoryProducer.
 */