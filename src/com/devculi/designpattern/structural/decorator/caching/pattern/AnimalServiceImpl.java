package com.devculi.designpattern.structural.decorator.caching.pattern;


public class AnimalServiceImpl implements AnimalService {
	

	private Animal loadAnimalFromDb(String name) {
		System.out.println("Loading animal from database");
		return  new Animal("dog","gau gau");
	}

	@Override
	public Animal getAnimal(String name) {
		CacheDecorator<String, Animal> cacheDecorator = new CacheDecorator<>(this::loadAnimalFromDb);
		 return cacheDecorator.apply(name);
	}

}
