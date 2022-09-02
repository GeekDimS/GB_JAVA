package org.example.Sem1_OOP;

public class Person {
    private final String name;
    private final String surName;
    private final int age;
    private final SexType sex;

    public Person(String name, String surName, int age, SexType sex) {
        this.name = name;
        this.surName = surName;
        this.age = age;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public String getSurName() {
        return surName;
    }

    public int getAge() {
        return age;
    }

    public SexType getSex() {
        return sex;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surName='" + surName + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                '}';
    }
}
