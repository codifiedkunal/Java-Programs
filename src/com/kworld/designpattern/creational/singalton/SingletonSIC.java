package com.kworld.designpattern.creational.singalton;

/*
 * SingletonENUM using static inner class
 * This is a widely used approach for a SingletonENUM class as it doesn’t require synchronization,
 * is thread safe, enforces lazy initialization and has comparatively less boilerplate
 */
public class SingletonSIC {
    private SingletonSIC(){}
    private static class SinletonHolder {
        public static final SingletonSIC instance = new SingletonSIC();
    }

    public static SingletonSIC getInstance(){
        return SinletonHolder.instance;
    }
}
