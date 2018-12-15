package com.kworld.designpattern.creational.singalton;

import java.io.ObjectStreamException;
import java.io.Serializable;

/*
 * Eager Initialize & Handling Serialization issue
 */
public class Singleton implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final Singleton INSTANCE = new Singleton();
    private Singleton() {
    }
    protected Object readResolve() throws ObjectStreamException {
        return INSTANCE;
    }
}