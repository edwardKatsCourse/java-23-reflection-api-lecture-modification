package com.junit;

import com.junit.exception.ClassIsNotTestableException;
import com.junit.exception.SystemMethodException;
import com.junit.tests.ExampleTest;
import com.junit.tests.StringTest;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Main {

    static Class [] classes = {StringTest.class, ExampleTest.class};


    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        for (Class clazz : classes) {

            if (!Testable.class.isAssignableFrom(clazz)) {
                throw new ClassIsNotTestableException(clazz);
            }

            System.out.println();
            System.out.printf("RUNNING TEST CLASS: [%s]%n", clazz.getName());
            runClass(clazz);
        }
    }

    public static void runClass(Class clazz) throws InstantiationException, IllegalAccessException {
        Method [] methods = getOrderedMethods(clazz);

        Object currentTestInstance = clazz.newInstance(); //ExampleTest exampleTest = new ExampleTest()
        for (Method method :methods) {
            runMethod(method, currentTestInstance); //currentInstance is like a reference on exampleTest
        }
    }

    public static Method [] getOrderedMethods(Class clazz) {
        Method [] methods = clazz.getDeclaredMethods();
        Arrays.sort(methods, new MethodComparator());

        return methods;
    }

    public static void runMethod(Method method, Object currentTestInstance) throws IllegalAccessException, InstantiationException {
        SystemMethod systemMethod = SystemMethod.getByName(method.getName());

        boolean isTestMethod = systemMethod == null;

        InvocationTargetException exception = null;
        try {
            method.invoke(currentTestInstance);

        } catch (InvocationTargetException e) {
            exception = e;
        }


        if (isTestMethod) {
            TestPrintUtil.printResult(method, exception);
        }

        if (!isTestMethod && exception != null) {

            throw new SystemMethodException(systemMethod, exception.getCause());
        }


        System.out.println("------------------");
    }





}
