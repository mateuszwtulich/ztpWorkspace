package com.example.model;

import java.io.Serializable;
import java.util.Objects;

public class Student implements Serializable {
    private String name;
    private String surname;
    private Integer index;

    public Student(Integer index, String name, String surname) {
        this.name = name;
        this.surname = surname;
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return name.equals(student.name) &&
                surname.equals(student.surname) &&
                index.equals(student.index);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, index);
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", index=" + index +
                '}';
    }
}
