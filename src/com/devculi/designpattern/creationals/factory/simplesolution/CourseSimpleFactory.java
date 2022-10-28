package com.devculi.designpattern.creationals.factory.simplesolution;

import java.util.UUID;

import com.devculi.designpattern.creationals.factory.bean.Course;
import com.devculi.designpattern.creationals.factory.bean.JavaCourse;
import com.devculi.designpattern.creationals.factory.bean.NetCourse;

public class CourseSimpleFactory
{
    private static Course course;

    public static Course getCourse(String userInput) {
        if (userInput.equalsIgnoreCase("Java")) {
            course =  new JavaCourse(UUID.randomUUID().toString(), "Java core");
            System.out.println("User choosed course Java with id " + course.getCourseId() + " and name " + course.getCourseName());
        }
        if (userInput.equalsIgnoreCase(".Net")) {
            course = new NetCourse(UUID.randomUUID().toString(), ".Net core");
            System.out.println("User choosed course .Net with id " + course.getCourseId() + " and name " + course.getCourseName());
        }
        return course;
    }
}
