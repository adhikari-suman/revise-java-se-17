package com.example.data_structures.stack;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;

public class StackExample {
    private static final Map<String, Integer> testCasesMap = new HashMap<>();

    static {
        testCasesMap.putIfAbsent("{}", 0);
        testCasesMap.putIfAbsent("{{}}", 0);
        testCasesMap.putIfAbsent("{}{}{}{}{}", 0);
        testCasesMap.putIfAbsent("{", -1);
        testCasesMap.putIfAbsent("}", -1);
        testCasesMap.putIfAbsent("{{", 1);
        testCasesMap.putIfAbsent("}}", 1);
        testCasesMap.putIfAbsent("{{{", -1);
        testCasesMap.putIfAbsent("}}}", -1);
        testCasesMap.putIfAbsent("{}{", -1);
        testCasesMap.putIfAbsent("{{{}", 1);
        testCasesMap.putIfAbsent("}{}{", 2);
        testCasesMap.putIfAbsent("{{}}{}", 0);
        testCasesMap.putIfAbsent("{{{{}}}}", 0);
        testCasesMap.putIfAbsent("{{{{{}}}}", -1);
        testCasesMap.putIfAbsent("{{{{}}}}}", -1);
        testCasesMap.putIfAbsent("}}}}}}}}", 4);
        testCasesMap.putIfAbsent("{{{{{{{{", 4);
        testCasesMap.putIfAbsent("}}{{", 2);
        testCasesMap.putIfAbsent("{{{{}}", 1);
        testCasesMap.putIfAbsent("}}{{{{{{}}", 3);
        testCasesMap.putIfAbsent("{{{{{{{{{{{{{{{{{{{{", 10);
        testCasesMap.putIfAbsent("}}}}}}}}}}}}}}}}}}}}", 10);
        testCasesMap.putIfAbsent("{{{{{{{{{{}}}}}}}}}}", 0);
        testCasesMap.putIfAbsent("}}{{}}{{}}{{}}{{}}{{}}", 1);
        testCasesMap.putIfAbsent("{{{{{{{{{{}}}}}}}}}}}}}}}}}}}", -1);
        testCasesMap.putIfAbsent("}}}}}}{{{{", 5);
        testCasesMap.putIfAbsent("{{{{}}}}}}}}", 2);
        testCasesMap.putIfAbsent("}}{{{{}}}}", 1);
        testCasesMap.putIfAbsent("}}}}{{{{", 4);
        testCasesMap.putIfAbsent("{{}}{{}}", 0);
        testCasesMap.putIfAbsent("{{{{{{{{{{{{}}}}}}}}}}}}", 0);
        testCasesMap.putIfAbsent("{{{{{{{{{{{{{{}}}}}}}}}}}}}}", 0);
        testCasesMap.putIfAbsent("}}}}}}}}}}{{{{{{{{", 9);
        testCasesMap.putIfAbsent("{{{{{{{{}}}}}}}}", 0);
        testCasesMap.putIfAbsent("{{{{}}}}}}}}}}}}}}}}}}}}}}}}", 10);
        testCasesMap.putIfAbsent("}}}}}}}}}}}}}}}}}}}}", 10);
        testCasesMap.putIfAbsent("{{{{}}}}}}{{{{}}}}", 1);
        testCasesMap.putIfAbsent("}}}}{{{{}}}}}}", 3);
        testCasesMap.putIfAbsent("}}{{{{}}}}}}{{", 3);
        testCasesMap.putIfAbsent("}}{{}}{{}}{{}}{{}}{{}}{{}}{{}}", 1);
        testCasesMap.putIfAbsent("}}}}}}}}}}{{{{{{{{{{{{}}}}}}}}}}}}", 5);
        testCasesMap.putIfAbsent("{{{{{{{{{{{{{{{{{{{{}}}}}}}}}}}}}}}}}}}}", 0);
        testCasesMap.putIfAbsent("}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}", 18);
        testCasesMap.putIfAbsent("{{{{{{{{{{{{{{{{}}}}}}}}}}}}}}}}", 0);
        testCasesMap.putIfAbsent("}}{{}}{{}}{{}}{{}}{{}}{{}}{{}}{{}}{{}}{{}}{{}}{{}}", 1);
        testCasesMap.putIfAbsent("}}{{}}{{}}{{}}{{}}{{}}{{}}{{}}{{}}{{}}{{}}{{}}{{}}{{}}{{}}{{}}{{}}", 1);
        // 32 reversals
        testCasesMap.putIfAbsent("{{{{}}}}{{{{}}}}{{{{}}}}", 0);
        testCasesMap.putIfAbsent("}}}}}}{{{{{{{{{{{{{{{{}}}}}}}}}}}}}}}}", 3);
        testCasesMap.putIfAbsent("{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{", 18);
        testCasesMap.putIfAbsent("}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}", 32);
        // reversals
    }

    public static void main(String[] args) {
        for (Map.Entry<String, Integer> entry : testCasesMap.entrySet()) {
            StackUsingLinkedListExample(entry);

            stackUsingArrayListExample(entry);
        }

    }

    public static void StackUsingLinkedListExample(Map.Entry<String, Integer> entry) {
        final long startTime = System.nanoTime();
        int  cost      = costOfBalancingBracketsWithLinkedList(entry.getKey());
        final long endTime   = System.nanoTime();

       final long duration = endTime - startTime;

        System.out.printf(
                "%-20s %nCase: %-20s %nExpected Cost:%5d %nCost: %5d %nTest: %6s %nDuration(ns): %d %n%n",
                "Using Linked-list:",
                entry.getKey(),
                entry.getValue(),
                cost,
                entry.getValue() == cost ? "PASSED" : "FAILED",
                duration
                         );
    }

    public static void stackUsingArrayListExample(Map.Entry<String, Integer> entry) {
        final long startTime = System.nanoTime();
        int  cost      = costOfBalancingBracketsWithStack(entry.getKey());
        final long endTime   = System.nanoTime();

        final long duration = endTime - startTime;

        System.out.printf(
                "%-20s %nCase: %-20s %nExpected Cost:%5d %nCost: %5d %nTest: %6s %nDuration(ns): %d %n%n",
                "Using Stack:",
                entry.getKey(),
                entry.getValue(),
                cost,
                entry.getValue() == cost ? "PASSED" : "FAILED",
                duration
                         );
    }

    private static int costOfBalancingBracketsWithStack(String brackets) {
        int cost = 0;

        if (brackets == null || brackets.isEmpty()) {
            return cost;
        } else if (brackets.length() % 2 == 1) {
            cost = -1;

            return cost;
        } else {
            Stack<Character> stack = new Stack<>();

            //1. add brackets to stack and pop-it if last and current are balanced right away
            for (int i = 0; i < brackets.length(); i++) {
                char bracket = brackets.charAt(i);

                // Add if empty and continue
                if (stack.isEmpty()) {
                    stack.push(bracket);
                    continue;
                }

                // Stack is not empty, check if previous and current brackets are balanced
                if (!isBracketBalanced(stack.getLast(), bracket)) {
                    stack.push(bracket);
                } else {
                    stack.pop();
                }
            }

            System.out.println("Brackets: " + stack);

            // 2. Calculate the cost to remove brackets
            while (!stack.isEmpty()) {
                // remember we are removing from last
                // so b2 is second bracket and b1 is first bracket
                char b2 = stack.pop();
                char b1 = stack.pop();

                cost += costToBalanceBracket(b1, b2);
            }

            return cost;
        }
    }

    private static int costOfBalancingBracketsWithLinkedList(String brackets) {
        int cost = 0;

        if (brackets == null || brackets.isEmpty()) {
            return cost;
        } else if (brackets.length() % 2 == 1) {
            cost = -1;

            return cost;
        } else {
            LinkedList<Character> stack = new LinkedList<>();

            //1. add brackets to stack and pop-it if last and current are balanced right away
            for (int i = 0; i < brackets.length(); i++) {
                char bracket = brackets.charAt(i);

                // Add if empty and continue
                if (stack.isEmpty()) {
                    stack.addLast(bracket);
                    continue;
                }

                // Stack is not empty, check if previous and current brackets are balanced
                if (!isBracketBalanced(stack.getLast(), bracket)) {
                    stack.addLast(bracket);
                } else {
                    stack.removeLast();
                }
            }

            // 2. Calculate the cost to remove brackets
            while (!stack.isEmpty()) {
                // remember we are removing from last
                // so b2 is second bracket and b1 is first bracket
                char b2 = stack.removeLast();
                char b1 = stack.removeLast();

                cost += costToBalanceBracket(b1, b2);
            }

            return cost;
        }
    }

    private static boolean isBracketBalanced(char open, char close) {
        return open == '{' && close == '}';
    }

    /**
     * @param open
     * @param close
     * @return cost of balancing brackets
     * <p>
     * There are four cases:
     * 1. open = '{', close = '}' => 0
     * 1. open = '{', close = '{' => 1
     * 1. open = '}', close = '}' => 1
     * 1. open = '}', close = '{' => 2
     */
    private static int costToBalanceBracket(char open, char close) {
        if (open == '{' && close == '}') {
            return 0;
        } else if (open == close) {
            return 1;
        } else {
            return 2;
        }
    }
}


