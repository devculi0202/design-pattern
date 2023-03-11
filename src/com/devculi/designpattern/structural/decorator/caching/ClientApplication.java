package com.devculi.designpattern.structural.decorator.caching;

import com.devculi.designpattern.structural.decorator.caching.nonpattern.Person;
import com.devculi.designpattern.structural.decorator.caching.nonpattern.PersonService;
import com.devculi.designpattern.structural.decorator.caching.nonpattern.PersonServiceImpl;
import com.devculi.designpattern.structural.decorator.caching.pattern.Animal;
import com.devculi.designpattern.structural.decorator.caching.pattern.AnimalService;
import com.devculi.designpattern.structural.decorator.caching.pattern.AnimalServiceImpl;

public class ClientApplication {
	public static void main(String[] args) {
       PersonService personService = new PersonServiceImpl();
       System.out.println("-------non-pattern--------");
       System.out.println("Get person first time");
       Person person1 =  personService.getPerson("duy");
       System.out.println(person1.toString());
       
       System.out.println("Get person second time");
       Person person2 =  personService.getPerson("duy");
       System.out.println(person2.toString());
       
       System.out.println("-------pattern--------");
       
       com.devculi.designpattern.structural.decorator.caching.pattern.PersonService personServicePattern = new com.devculi.designpattern.structural.decorator.caching.pattern.PersonServiceImpl();
       AnimalService animalService = new AnimalServiceImpl();
       System.out.println("Get person first time");
       Person person3 =  personServicePattern.getPerson("duy");
       System.out.println(person1.toString());
       
       System.out.println("Get animal second time");
       Person person4 =  personServicePattern.getPerson("duy");
       System.out.println(person2.toString());
       
       System.out.println("Get dog first time");
       Animal dog1=  animalService.getAnimal("dog");
       System.out.println(dog1.toString());
       
       System.out.println("Get dog second time");
       Animal dog2 =  animalService.getAnimal("dog");
       System.out.println(dog2.toString());
       
       
       
	}
}
