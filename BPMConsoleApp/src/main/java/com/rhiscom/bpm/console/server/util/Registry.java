package com.rhiscom.bpm.console.server.util;

import java.util.HashMap;
import java.util.Map;

public class Registry {
    private static Map<Class, Object> registry = new HashMap<Class, Object>();

    public static void set(Class key, Object obj) {
	registry.put(key, obj);
    }

    public static <T> T get(Class<T> key) {
	T t = (T) registry.get(key);
	if (null == t)
	    throw new IllegalArgumentException(key + " not registered");
	return t;
    }

    public static boolean has(Class key) {
	return get(key) != null;
    }

}