package com.devculi.designpattern.structural.decorator.caching.nonpattern;

import java.util.HashMap;
import java.util.Map;

public class PersonServiceImpl implements PersonService {
	private Map<String, Person> cache = new HashMap<>();
	
	@Override
	public Person getPerson(String name) {
		Person result = cache.get(name);
		
		if (result != null) {
			System.out.println("Getting person from cache");
			return result;
		}
	    else {
	    	System.out.println("Getting person from database");
	    	Person person = new Person(name, 25, "Dev");
	    	cache.put(name, person);
	    	return person;
		}
	}

}