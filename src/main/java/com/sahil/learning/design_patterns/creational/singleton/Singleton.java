package com.sahil.learning.design_patterns.creational.singleton;


/*
* The Singleton Design Pattern is a Creational pattern, whose objective is to create
* only one instance of a class and to provide only one global access point to that object.
* One commonly used example of such a class in Java is Calendar, where you cannot make an instance of that class.
* It also uses its own getInstance()method to get the object to be used.
 */

import lombok.Getter;

@Getter
public class Singleton {

    private static Singleton instance;

    private final String property;

    // lazy initialization
    private Singleton(final String property) {
        this.property = property;
    }

    public static Singleton getInstance() {

        if (instance == null) { // double locking to prevent performance drop when getInstance is called
            // Thread safe for multiple clients calling at same time
            synchronized (Singleton.class){
                if (instance == null) {
                    instance = new Singleton("final instance property");
                }
            }
        }
        return instance;
    }
}
