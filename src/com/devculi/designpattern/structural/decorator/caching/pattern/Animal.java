package com.devculi.designpattern.structural.decorator.caching.pattern;

public class Animal {
	private String name;
	private String behavior;

	public Animal(String name, String behavior) {
		super();
		this.name = name;
		this.behavior = behavior;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBehavior() {
		return behavior;
	}

	public void setBehavior(String behavior) {
		this.behavior = behavior;
	}

	@Override
	public String toString() {
		return "Animal [name=" + name + ", behavior=" + behavior + "]";
	}
}
