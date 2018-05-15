package com.junit.tests;

import com.junit.Testable;

public class StringTest implements Testable {
    private static final String INITIAL_TEXT = "This is my text";

    private String string;


    public void before() {
        string = INITIAL_TEXT;
    }

    public void stringIsNotNull() {
        if (string == null) {
            throw new RuntimeException("String is null");
        }
    }


    public void stringDidNotChangeTest() {
        string.toUpperCase();

        if (!string.equals(INITIAL_TEXT)) {
            throw new RuntimeException("String is broken");
        }
    }

    public void substringOfFirstFiveCharacters() {
        String result = string.substring(0, 6);
        if (!result.equals("This ")) {
            throw new RuntimeException("Substring is incorrect");
        }
    }

    public void after() {
        string = null;
    }

}
