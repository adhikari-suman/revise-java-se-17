package com.example.data_structures.stack;

import java.util.HashMap;
import java.util.Map;

public class StackExample {
    private static final Map<String, Integer> testCasesMap = new HashMap<String, Integer>();

     static  {
         testCasesMap.putIfAbsent("{}", 0);
         testCasesMap.putIfAbsent("{{}}", 0);
         testCasesMap.putIfAbsent("{}{}{}{}{}", 0);
         testCasesMap.putIfAbsent("{", -1);  // Odd length - cannot be balanced
         testCasesMap.putIfAbsent("}", -1);  // Odd length - cannot be balanced
         testCasesMap.putIfAbsent("{{", 1);  // Needs one reversal
         testCasesMap.putIfAbsent("}}", 1);  // Needs one reversal
         testCasesMap.putIfAbsent("{{{", -1);  // Odd length - cannot be balanced
         testCasesMap.putIfAbsent("}}}", -1);  // Odd length - cannot be balanced
         testCasesMap.putIfAbsent("{}{", -1);  // Odd length - cannot be balanced
         testCasesMap.putIfAbsent("{{{}", 2);  // Needs two reversals
         testCasesMap.putIfAbsent("}{}{", 2);  // Needs two reversals
         testCasesMap.putIfAbsent("{{}}{}", 0);  // Already balanced
         testCasesMap.putIfAbsent("{{{{}}}}", 0);  // Already balanced
         testCasesMap.putIfAbsent("{{{{{}}}}", -1);  // Odd length - cannot be balanced
         testCasesMap.putIfAbsent("{{{{}}}}}", 1);  // One reversal needed
         testCasesMap.putIfAbsent("}}}}}}}}", 4);  // Four reversals needed
         testCasesMap.putIfAbsent("{{{{{{{{", 4);  // Four reversals needed
         testCasesMap.putIfAbsent("}}{{", 2);  // Two swaps needed
         testCasesMap.putIfAbsent("{{{{}}", 1);  // Needs one reversal
         testCasesMap.putIfAbsent("}}{{{{{{}}", 3);  // Three reversals needed

     }

    public static void main(String[] args) {
        StackUsingLinkedListExample();

        stackUsingArrayListExample();
    }

    public static void StackUsingLinkedListExample(){

    }

    public static void stackUsingArrayListExample(){

    }
}
