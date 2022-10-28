package com.devculi.designpattern.creationals.factory.devculisolution;

import java.util.UUID;

import com.devculi.designpattern.creationals.factory.bean.Course;
import com.devculi.designpattern.creationals.factory.bean.NetCourse;

public class NetCourseFactory implements CourseFactory
{
    private Course course;

    /**
     * @see com.devculi.designpattern.creationals.factory.devculisolution.CourseFactory#getCourse(java.lang.String)
     */
    @Override
    public Course getCourse()
    {
        course =  new NetCourse(UUID.randomUUID().toString(), ".Net core");
        System.out.println("User choosed course .Net with id " + course.getCourseId() + " and name " + course.getCourseName());
        return course;
    }

}
