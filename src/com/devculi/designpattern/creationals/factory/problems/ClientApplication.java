package com.devculi.designpattern.creationals.factory.problems;

import java.util.UUID;

import com.devculi.designpattern.creationals.factory.bean.Client;
import com.devculi.designpattern.creationals.factory.bean.Course;
import com.devculi.designpattern.creationals.factory.bean.JavaCourse;
import com.devculi.designpattern.creationals.factory.bean.NetCourse;

public class ClientApplication
{
    private static Course course = null;
    private static String option1 = "Java";
    private static String option2 = ".Net";

    public static void main(String[] args)
    {
       Client client = new Client();
        //Client want to learn Java
       if(client.chooseOption("Java").equalsIgnoreCase(option1)) {
          course = new JavaCourse(UUID.randomUUID().toString(), "Java 8");
       }
     //Client want to learn .Net
       if(client.chooseOption(".Net").equalsIgnoreCase(option2)) {
           course = new NetCourse(UUID.randomUUID().toString(), ".Net core");
       }
       course.createCourseDetail();
       course.createCourseSchedule();
    }
}

/*
 * In the future, if we have a new php course, we have to :
 * 1.Create PhpCourse, extends Course.
 * 2. Create option3 = "Php" at ClientApplication.
 * 3. Check if client choose option3, create new PhpCourse.
 * ==>Thus, we have to modify method main() at ClientApplication and the method main bulges (phình to) as well.
 * 
 * if we have another client who wants to reuse previous course instance, it is impossile. For example
 * In the future, we has MobileClient wants use course function and that client only a option is Java, the mobileClient cannot reuse the previous client code.
 * The MobileClient have to implement as below: 
 * 
 *  Client client = new MobileClient();
   //Client want to learn Java
   if(client.chooseOption("Java").equalsIgnoreCase(option1)) {
       course = new JavaCourse(UUID.randomUUID().toString(), "Java 8");
   }
   course.createCourseDetail();
   course.createCourseSchedule();
 */
