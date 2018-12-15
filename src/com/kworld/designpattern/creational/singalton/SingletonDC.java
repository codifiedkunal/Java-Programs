package com.kworld.designpattern.creational.singalton;

/*
 *  Double Check
 */
public class SingletonDC {
    private static SingletonDC INSTANCE = null;
    private SingletonDC() {}
    public static SingletonDC getInstance() {
        if (INSTANCE == null) {
            synchronized (SingletonDC.class) {
                if (INSTANCE == null) {
                    INSTANCE = new SingletonDC();
                }
            }
        }
        return INSTANCE;
    }
}