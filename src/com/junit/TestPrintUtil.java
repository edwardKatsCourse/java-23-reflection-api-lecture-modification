package com.junit;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestPrintUtil {

    public static void printResult(Method method, InvocationTargetException e) {
        TestStatus testStatus = e == null ? TestStatus.PASSED : TestStatus.FAILED;

        System.out.printf("Method: [%s] has %s%n", method.getName(), testStatus.name());

        if (testStatus == TestStatus.FAILED) {
            Throwable cause = e.getCause();
            System.out.printf("Exception type: [%s]%n" +
                    "Exception message: [%s]%n",
                    cause.getClass().getName(),
                    cause.getMessage());
        }
    }





}
