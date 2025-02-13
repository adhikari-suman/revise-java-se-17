package com.example.initialization_blocks;

public class Independent {

    public static final String CLASS_NAME = Independent.class.getSimpleName();
    public static       int    x;

    // static block
    static {
        x = 12;
        System.out.printf("%s: Inside static block%n", CLASS_NAME);
    }

    static {
        x = 13;
        System.out.printf("%s: Inside static block 2. %n", CLASS_NAME);
    }

    public int age;

    // Object initializers
    {
        age = 21;
        System.out.printf("%s: Inside instance block. Age is %d.%n", CLASS_NAME, age);
    }

    public Independent() {
        age = 0;
        System.out.printf("%s: Inside constructor. Age is %d.%n", CLASS_NAME, age);
    }


    public static void main(String[] args) {
        Independent independent = new Independent();
    }
}
