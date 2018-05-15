package com.junit.tests;

import com.junit.Testable;

public class ExampleTest implements Testable {

    private Integer value;

    public void before() {
        value = 15;

        throw new RuntimeException("Beore is broken");
    }

    public void testMethod() {
        System.out.println("testMethod");
        System.out.println(value);
    }

    public void after() {

    }
}

class Run {
    public static void main(String[] args) {
        ExampleTest exampleTest = new ExampleTest();
        exampleTest.before();
        exampleTest.testMethod();

        System.out.println("*************");

        new ExampleTest().before();

        new ExampleTest().testMethod();
        new ExampleTest().testMethod();
        new ExampleTest().testMethod();
        new ExampleTest().testMethod();

        Person peter = new Person(45, "Peter");
        new Person(51, "David");

    }


}
class Person {

    private Integer age;
    private String name;

    public Person(Integer age, String name) {
        this.age = age;
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
