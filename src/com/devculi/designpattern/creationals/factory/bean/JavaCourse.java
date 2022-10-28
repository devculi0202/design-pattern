package com.devculi.designpattern.creationals.factory.bean;

public class JavaCourse extends  Course
{

    public JavaCourse(String courseId, String courseName)
    {
        super(courseId, courseName);
    }

    /**
     * @see com.devculi.designpattern.creationals.factory.bean.Course#createCourseDetail()
     */
    @Override
    public void createCourseDetail()
    {
        System.out.println("Create Java course detail");
    }

    /**
     * @see com.devculi.designpattern.creationals.factory.bean.Course#createCourseSchedule()
     */
    @Override
    public void createCourseSchedule()
    {
        System.out.println("Create Java course schedule");
    }

}
