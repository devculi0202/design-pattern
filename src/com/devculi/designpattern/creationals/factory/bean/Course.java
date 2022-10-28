package com.devculi.designpattern.creationals.factory.bean;

public abstract class Course
{
    private String courseId;
    private String courseName;

    /**
     * Constructor
     *
     * @param courseId
     * @param courseName
     */
    public Course(String courseId, String courseName)
    {
        this.courseId = courseId;
        this.courseName = courseName;
    }

    /**
     * Gets the courseId
     *
     * @return Returns the courseId
     */
    public String getCourseId()
    {
        return courseId;
    }

    /**
     * Sets the courseId
     *
     * @param courseId The courseId to set
     */
    public void setCourseId(String courseId)
    {
        this.courseId = courseId;
    }

    /**
     * Gets the courseName
     *
     * @return Returns the courseName
     */
    public String getCourseName()
    {
        return courseName;
    }

    /**
     * Sets the courseName
     *
     * @param courseName The courseName to set
     */
    public void setCourseName(String courseName)
    {
        this.courseName = courseName;
    }

    public abstract void createCourseDetail();
    public abstract void createCourseSchedule();



}
