package com.company;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class Main {
      //Поиск операции "возведение в степень"
    public static final int START = 0;
    public static final int DIGIT1 = 1;
    public static final int DOT1 = 2;
    public static final int DIGIT2 = 3;

    public static void main(String[] args) {
        List<Character> digits = Arrays.asList('0', '1', '2', '3', '4', '5', '6', '7', '8', '9');
        Set<Integer> endStates = Collections.singleton(DIGIT2);
        StateMachine sm = new StateMachine(START, endStates);
        sm.add(START, digits, DIGIT1);
        sm.add(DIGIT1, digits, DIGIT1);
        sm.add(DIGIT1, '^', DOT1);
        sm.add(DOT1, digits, DIGIT2);
        sm.add(DIGIT2, digits, DIGIT2);

        // Поиск всех вхождений в строке:
        String str = "abba 25^2 xyzzy 5^7 ababa 56^67 gggg 123^6";
        sm.findAll(str);
    }
}
