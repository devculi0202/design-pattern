package com.devculi.designpattern.structural.decorator.caching.pattern;


import com.devculi.designpattern.structural.decorator.caching.nonpattern.Person;

public class PersonServiceImpl implements PersonService {
	
	private Person loadPersonFromDb(String name) {
		System.out.println("Loading person from database");
		return  new Person(name,27,"Job");
		
	}

	@Override
	public Person getPerson(String name) {
		CacheDecorator<String, Person> cacheDecorator =  new CacheDecorator<>(this::loadPersonFromDb);
	    return cacheDecorator.apply(name);
	}
}
