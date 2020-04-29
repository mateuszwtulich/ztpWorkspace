package com.company;

import com.company.enumerator.Gender;
import com.company.model.Course;
import com.company.model.Faculty;
import com.company.model.Student;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Generator generator = new Generator();

        List<Faculty> faculties = generator.gFaculties();
        List<Course> courses =  generator.gCourses();
        List<Student> students = generator.gStudents(faculties, courses);

        //Filter
        System.out.println("\n####################################################FILTER##########################################################");
        System.out.println("\nKursy z 4 punktami ECTS:");
        courses.stream().filter(course -> course.getEctsPoints() == 4).forEach(course -> System.out.println(course.toString()));

        System.out.println("\nWydziały utworzone w 1968 roku:");
        faculties.stream().filter(faculty -> faculty.getDateOfEstablishment().getYear() == 68).forEach(faculty -> System.out.println(faculty.toString()));

        System.out.println("\nStudenci o płci żeńskiej:");
        students.stream().filter(student -> student.getGender() == Gender.FEMALE).forEach(student -> System.out.println(student.toString()));

        System.out.println("\nStudenci w wieku 22:");
        students.stream().filter(student -> student.getAge() == 22).forEach(student -> System.out.println(student.toString()));

        //Map
        System.out.println("\n####################################################MAP##########################################################");
        final int[] i = {0};
        System.out.println("\nNumer indeksu studenta, a wydział:");
        students.stream().map(student -> student.getFaculty()).forEach(faculty -> System.out.println(students.get(i[0]++).getIndex() + ": " + faculty.getName()));

        final int[] j = {0};
        System.out.println("\nNumer indeksu studenta, a liczba powiązanych kursów:");
        students.stream().map(student -> student.getCourseList().size()).forEach(number -> System.out.println(students.get(j[0]++).getIndex() + ": " + number));

        //Max/Min
        System.out.println("\n#################################################MAX/MIN#########################################################");

        System.out.println("\nStudent o najwyższej liczbie powiązanych kursów:");
        System.out.println(students.stream().max(Comparator.comparing(student -> student.getCourseList().size())).get().toString());

        System.out.println("\nStudent o najniższej liczbie powiązanych kursów:");
        System.out.println(students.stream().min(Comparator.comparing(student -> student.getCourseList().size())).get().toString());

        //GroupingBy
        System.out.println("\n###################################################GROUPING########################################################\n");

        Map<Gender, Double> averageAgePerGender = students.stream().collect(Collectors.groupingBy(Student::getGender, Collectors.averagingInt(Student::getAge)));
        averageAgePerGender.forEach((gender, aDouble) -> System.out.println("Średni wiek studentów o płci " + gender + ": " + aDouble));

        System.out.println("\nLiczba ECTS dla każdego studenta: ");
        students.stream().forEach(student -> System.out.println(student.getIndex() + ": " + student.getCourseList().stream()
                .collect(Collectors.summarizingInt(Course::getEctsPoints)).getSum()));

        System.out.println();
        Map<Faculty, Long> studentsPerFaculty = students.stream().collect(Collectors.groupingBy(Student::getFaculty, Collectors.counting()));
        studentsPerFaculty.forEach((faculty, aLong) -> System.out.println("Liczba studentów na wydziale " + faculty.getName() + ": " + aLong));

        System.out.println("\nŚrednia liczba ECTSów wszystkich kursów: " + courses.stream().collect(Collectors.averagingInt(Course::getEctsPoints)).toString());
    }
}
