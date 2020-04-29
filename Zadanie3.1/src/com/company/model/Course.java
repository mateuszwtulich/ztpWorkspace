package com.company.model;

import java.util.Objects;

public class Course {
    private String code;
    private String name;
    private int numberOfHours;
    private int ectsPoints;

    public Course(String code, String name, int numberOfHours, int ectsPoints) {
        this.code = code;
        this.name = name;
        this.numberOfHours = numberOfHours;
        this.ectsPoints = ectsPoints;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfHours() {
        return numberOfHours;
    }

    public void setNumberOfHours(int numberOfHours) {
        this.numberOfHours = numberOfHours;
    }

    public int getEctsPoints() {
        return ectsPoints;
    }

    public void setEctsPoints(int ectsPoints) {
        this.ectsPoints = ectsPoints;
    }

    @Override
    public String toString() {
        return "Kurs " +
                "o kodzie: " + code +
                ", nazwa: " + name +
                ", liczba godzin: " + numberOfHours +
                ", punkty ECTS: " + ectsPoints;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Course)) return false;
        Course course = (Course) o;
        return numberOfHours == course.numberOfHours &&
                ectsPoints == course.ectsPoints &&
                code.equals(course.code) &&
                name.equals(course.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, name, numberOfHours, ectsPoints);
    }
}
