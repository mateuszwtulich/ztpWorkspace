package com.company;

import com.company.enumerator.Gender;
import com.company.model.Course;
import com.company.model.Faculty;
import com.company.model.Student;

import java.util.*;

public class Generator {

    public List<Faculty> gFaculties(){
        ArrayList<Faculty> faculties = new ArrayList<>();

        faculties.add(new Faculty("Informatyki i Zarządzania",
                new GregorianCalendar(1968, Calendar.SEPTEMBER, 1).getTime(), "Łukasiewicza 5, 50-371 Wrocław"));
        faculties.add(new Faculty("Elektroniki",
                new GregorianCalendar(1968, Calendar.SEPTEMBER, 28).getTime(), "Janiszewskiego 11/17, 50-372 Wrocław"));
        faculties.add(new Faculty("Mechaniczny",
                new GregorianCalendar(1949, Calendar.SEPTEMBER, 1).getTime(), "Łukasiewicza 5/7, 50-370 Wrocław"));
        faculties.add(new Faculty("Podstawowych Problemów Techniki",
                new GregorianCalendar(1963, Calendar.SEPTEMBER, 1).getTime(), "wybrzeże Stanisława Wyspiańskiego 27, 50-370 Wrocław"));

        return faculties;
    }

    public List<Course> gCourses(){
        ArrayList<Course> courses = new ArrayList<>();

        courses.add(new Course("LN23", "Hurtownie danych", 90, 4));
        courses.add(new Course("LN24", "Sztuczna inteligencja", 120, 6));
        courses.add(new Course("LN25", "Robotyka", 60, 4));
        courses.add(new Course("LN26", "Bazy danych", 90, 5));
        courses.add(new Course("LN27", "Podstawy mechaniki", 90, 4));
        courses.add(new Course("LN28", "Fizyka kwantowa", 120, 7));
        courses.add(new Course("LN29", "Podstawy programowania", 60, 2));
        courses.add(new Course("LN30", "Analiza matematyczna", 120, 4));
        courses.add(new Course("LN22", "Algebra", 90, 3));
        courses.add(new Course("LN21", "Technologie informatyczne", 60, 4));
        courses.add(new Course("LN20", "Architektura komputerów", 60, 2));

        return courses;
    }

    public List<Student> gStudents(List<Faculty> faculties, List<Course> courses){
        ArrayList<Student> students = new ArrayList<>();

        students.add(new Student(231243, "Ania", "Nowak", 21, Gender.FEMALE, faculties.get(1)));
        students.get(0).setCourseList(courses.subList(0,4));
        students.add(new Student(231244, "Ula", "Nowak", 22, Gender.FEMALE, faculties.get(2)));
        students.get(1).setCourseList(courses.subList(2,10));
        students.add(new Student(231245, "Kamila", "Kowalska", 23, Gender.FEMALE, faculties.get(3)));
        students.get(2).setCourseList(courses.subList(4,11));
        students.add(new Student(231233, "Kamil", "Kowal", 24, Gender.MALE, faculties.get(0)));
        students.get(3).setCourseList(courses.subList(5,9));
        students.add(new Student(231143, "Dariusz", "Mróz", 22, Gender.MALE, faculties.get(1)));
        students.get(4).setCourseList(courses.subList(0,7));
        students.add(new Student(231443, "Piotr", "Woldan", 20, Gender.MALE, faculties.get(1)));
        students.get(5).setCourseList(courses.subList(0,9));
        students.add(new Student(231543, "Tomasz", "Kot", 23, Gender.MALE, faculties.get(2)));
        students.get(6).setCourseList(courses.subList(2,10));
        students.add(new Student(231643, "Piotr", "Lis", 23, Gender.MALE, faculties.get(3)));
        students.get(7).setCourseList(courses.subList(7,11));
        students.add(new Student(231247, "Igor", "Tomasz", 22, Gender.MALE, faculties.get(3)));
        students.get(8).setCourseList(courses.subList(5,9));
        students.add(new Student(231248, "Jakub", "Balet", 20, Gender.MALE, faculties.get(2)));
        students.get(9).setCourseList(courses.subList(4,10));
        students.add(new Student(231249, "Łukasz", "Nowak", 19, Gender.MALE, faculties.get(0)));
        students.get(10).setCourseList(courses.subList(0,4));
        students.add(new Student(241243, "Kamil", "Nowak", 25, Gender.MALE, faculties.get(0)));
        students.get(11).setCourseList(courses.subList(2,9));
        students.add(new Student(251243, "Paweł", "Czesz", 23, Gender.MALE, faculties.get(0)));
        students.get(12).setCourseList(courses.subList(6,10));
        students.add(new Student(261243, "Grzegorz", "Kawa", 24, Gender.MALE, faculties.get(2)));
        students.get(13).setCourseList(courses.subList(3,7));
        students.add(new Student(271243, "Marek", "Polak", 22, Gender.MALE, faculties.get(2)));
        students.get(14).setCourseList(courses.subList(7,11));
        students.add(new Student(281243, "Wiktoria", "Trawa", 19, Gender.FEMALE, faculties.get(1)));
        students.get(15).setCourseList(courses.subList(3,5));
        students.add(new Student(291243, "Weronika", "Powa", 19, Gender.FEMALE, faculties.get(1)));
        students.get(16).setCourseList(courses.subList(2,9));
        students.add(new Student(221243, "Patrycja", "Sowa", 20, Gender.FEMALE, faculties.get(3)));
        students.get(17).setCourseList(courses.subList(1,8));
        students.add(new Student(211243, "Agnieszka", "Mikuc", 21, Gender.FEMALE, faculties.get(0)));
        students.get(18).setCourseList(courses.subList(3,8));

        return students;
    }
}
