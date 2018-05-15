package com.junit.exception;

public class ClassIsNotTestableException extends GeneralAPIException {

    public ClassIsNotTestableException(Class clazz) {
        super(String.format("Class [%s] must implement Testable in order to be executed", clazz.getName()));
    }
}
