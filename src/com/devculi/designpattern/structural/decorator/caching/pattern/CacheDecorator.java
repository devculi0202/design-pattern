package com.devculi.designpattern.structural.decorator.caching.pattern;

import java.util.function.Function;

public class CacheDecorator<T, R> implements Function<T, R> {

	private Function<T, R> function;

	public CacheDecorator(Function<T, R> function) {
		this.function = function;
	}

	@Override
	public R apply(T t) {
		R result = CacheSingleton.<T, R>getInstance().get(t);
		if (result != null) {
			System.out.println("Getting from cache");
			return result;
		} else {
			System.out.println("Getting from database");
			R resultFromDb = function.apply(t);
			CacheSingleton.<T, R>getInstance().put(t, resultFromDb);
			return resultFromDb;
		}
	}
}
