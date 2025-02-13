package com.example.objects_and_classes;

// Immutable class
public class User {

    private final String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static void main(String[] args) {
        User user = new User("John");

        System.out.println(user.getName());
    }
}
