package com.devculi.designpattern.structural.decorator.caching.pattern;

import java.util.HashMap;
import java.util.Map;

public class CacheSingleton<T,R> {
	private static CacheSingleton instance;
	private Map<T,R> cache;
	
	private CacheSingleton() {
		cache = new HashMap<>();
	}
	
	public static synchronized <T,R> CacheSingleton<T,R> getInstance() {
		if (instance == null) {
			instance = new CacheSingleton<T,R>();
		}
		return instance;
	}
	
	public synchronized R get(T key) {
		return cache.get(key);
	}
	
	public synchronized void put(T key, R value) {
		cache.put(key, value);
	}

}
