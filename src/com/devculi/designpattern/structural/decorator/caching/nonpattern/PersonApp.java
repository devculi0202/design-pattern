package com.devculi.designpattern.structural.decorator.caching.nonpattern;

import com.devculi.designpattern.structural.decorator.caching.nonpattern.Person;
import com.devculi.designpattern.structural.decorator.caching.nonpattern.PersonService;
import com.devculi.designpattern.structural.decorator.caching.nonpattern.PersonServiceImpl;

public class PersonApp {
	public static void main(String[] args) {
       PersonService personService = new PersonServiceImpl();
       System.out.println("Get person first time");
       Person person1 =  personService.getPerson("duy");
       System.out.println(person1.toString());
       
       System.out.println("Get person second time");
       Person person2 =  personService.getPerson("duy");
       System.out.println(person2.toString());
	}
}
