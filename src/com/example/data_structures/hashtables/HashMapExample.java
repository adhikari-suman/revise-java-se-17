package com.example.data_structures.hashtables;

import java.util.HashMap;
import java.util.Map;

public class HashMapExample {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();

        map.put("Ariel", 18);
        map.put("Cinderella", 16);


        map.forEach((key, value) -> System.out.println(key + "'s age is " + value + "."));
    }
}
