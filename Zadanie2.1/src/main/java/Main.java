import config.Generator;
import copy.CloneableCopy;
import copy.ReflectionCopy;
import copy.SerializationCopy;
import copy.SerializationUtilsCopy;
import entity.University;

import java.io.*;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws CloneNotSupportedException, IOException, ClassNotFoundException {
        printResultsFor(1, 2, 50);
        printResultsFor(2, 5, 100);
        printResultsFor(5, 20, 100);
    }

    private static void printResultsFor(int numberOfUniversities, int numberOfFaculties, int numberOfStudents) throws CloneNotSupportedException, IOException, ClassNotFoundException {
        Generator generator = new Generator();
        System.out.println("\n##################################################################");
        System.out.println("Results for: " + numberOfUniversities + " x " + numberOfFaculties + " x " + numberOfStudents);
        University[] generatedUniversities = generator.generate(numberOfUniversities,numberOfFaculties,numberOfStudents);
        University[] copiedUniversities = CloneableCopy.cloneableCopy(generatedUniversities);
        printIsCorrect(generatedUniversities, copiedUniversities);

        copiedUniversities = SerializationUtilsCopy.serializationUtilsCopy(generatedUniversities);
        printIsCorrect(generatedUniversities, copiedUniversities);

        copiedUniversities = SerializationCopy.serializationCopy(generatedUniversities);
        printIsCorrect(generatedUniversities, copiedUniversities);

        copiedUniversities = ReflectionCopy.reflectionCopy(generatedUniversities);
        printIsCorrect(generatedUniversities, copiedUniversities);
    }

    private static boolean validateCopy(University[] expected, University[] actual){
        return Arrays.deepEquals(expected, actual);
    }

    private static void printIsCorrect(University[] expected, University[] actual){
        System.out.println("Is copy correct? " + validateCopy(expected, actual));
    }
}
