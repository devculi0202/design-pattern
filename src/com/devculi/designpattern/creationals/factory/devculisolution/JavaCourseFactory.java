package com.devculi.designpattern.creationals.factory.devculisolution;

import java.util.UUID;

import com.devculi.designpattern.creationals.factory.bean.Course;
import com.devculi.designpattern.creationals.factory.bean.JavaCourse;

public class JavaCourseFactory implements CourseFactory
{
    private Course course;

    /**
     * @see com.devculi.designpattern.creationals.factory.devculisolution.CourseFactory#getCourse(java.lang.String)
     */
    @Override
    public Course getCourse()
    {
        course =  new JavaCourse(UUID.randomUUID().toString(), "Java core");
        System.out.println("User choosed course Java with id " + course.getCourseId() + " and name " + course.getCourseName());
        return course;
    }

}
