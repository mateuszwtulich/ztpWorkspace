package com.company.model;

import com.company.enumerator.Gender;

import java.util.List;
import java.util.Objects;

public class Student {
    private int index;
    private String name;
    private String surname;
    private int age;
    private Gender gender;
    private Faculty faculty;
    private List<Course> courseList;

    public Student(int index, String name, String surname, int age, Gender gender, Faculty faculty) {
        this.index = index;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.gender = gender;
        this.faculty = faculty;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }

    @Override
    public String toString() {
        return "Student " +
                "o indeksie: " + index +
                ", imię: " + name + '\'' +
                ", nazwisko: " + surname + '\'' +
                ", wiek: " + age +
                ", płeć: " + gender +
                ", wydział: " + faculty.getName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return index == student.index &&
                age == student.age &&
                name.equals(student.name) &&
                surname.equals(student.surname) &&
                gender == student.gender &&
                faculty.equals(student.faculty) &&
                courseList.equals(student.courseList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(index, name, surname, age, gender, faculty, courseList);
    }
}
