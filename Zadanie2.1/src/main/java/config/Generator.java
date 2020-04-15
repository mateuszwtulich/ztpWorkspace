package config;

import entity.Faculty;
import entity.Student;
import entity.University;

import java.time.LocalDate;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Generator {

    public University[] generate(int numberOfUniversities, int numberOfFaculties, int numberOfStudents){
        University[] universities = new University[numberOfUniversities];

        for (int i = 0; i < numberOfUniversities; i++) {
            Faculty[] faculties = new Faculty[numberOfFaculties];
            for (int j = 0; j < numberOfFaculties; j++) {
                Student[] students = new Student[numberOfStudents];
                for (int k = 0; k < numberOfStudents; k++) {
                    Student student = new Student(generateString(), generateString(), generateInteger());
                    students[k] = student;
                }
                Faculty faculty = new Faculty(generateString(), generateLocalDate(), students);
                faculties[j] = faculty;
            }
            University university = new University(generateString(), generateLocalDate(), generateString(), faculties);
            universities[i] = university;
        }

        return universities;
    }

    private String generateString(){
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(targetStringLength);
        for (int i = 0; i < targetStringLength; i++) {
            int randomLimitedInt = leftLimit + (int)
                    (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }
        return buffer.toString();
    }

    private Integer generateInteger(){
        return ThreadLocalRandom.current().nextInt(100000, 1000000);
    }

    private LocalDate generateLocalDate(){
        long minDay = LocalDate.of(1570, 1, 1).toEpochDay();
        long maxDay = LocalDate.of(2020, 4, 15).toEpochDay();
        long randomDay = ThreadLocalRandom.current().nextLong(minDay, maxDay);
        return LocalDate.ofEpochDay(randomDay);
    }
}
