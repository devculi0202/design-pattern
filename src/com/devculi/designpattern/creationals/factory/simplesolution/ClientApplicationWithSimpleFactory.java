package com.devculi.designpattern.creationals.factory.simplesolution;


import com.devculi.designpattern.creationals.factory.bean.Client;
import com.devculi.designpattern.creationals.factory.bean.Course;

public class ClientApplicationWithSimpleFactory
{
    private static Course course = null;

    public static void main(String[] args)
    {
       Client client = new Client();
       course = CourseSimpleFactory.getCourse(client.chooseOption(".Net"));
       course.createCourseDetail();
       course.createCourseSchedule();
    }
}


/*
 * With this way, we resolved the problem that is cannot reuse code.
 * 1.The client code doesn't care about the course creation.
 * 2.The CourseSimpleFactory has responsibility create course.
 * ==> If we have another client (MobileClient) and it only a option Java, we will implement as below
 *
 *  Client client = new Mobile();
    course = CourseSimpleFactory.getCourse(client.chooseOption("Java"));
 *
 * But, it seems we haven't resolved the bulge problem and the modification method yet.
 * Anytime we introduce a new course or JavaCourse change, we must to modify method getCourse().It violates SOLID principle SRP (a class, method, module should have only reason to change. )
 */
