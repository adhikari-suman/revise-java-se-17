package com.example.initialization_blocks;

public class Parent {

    public static final String CLASS_NAME = Parent.class.getSimpleName();

    // static block
    static {
        System.out.printf("%s: Inside static block #1%n", CLASS_NAME);
    }

    static {
        System.out.printf("%s: Inside static block #2.%n", CLASS_NAME);
    }

    // Object initializers
    {
        System.out.printf("%s: Inside instance block #1.%n", CLASS_NAME);
    }

    // Object initializers
    {
        System.out.printf("%s: Inside instance block #2.%n", CLASS_NAME);
    }

    public Parent() {
        System.out.printf("%s: Inside constructor.%n", CLASS_NAME);
    }
}
