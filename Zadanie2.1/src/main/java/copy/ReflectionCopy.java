package copy;

import config.Generator;
import entity.University;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.time.LocalDate;

public class ReflectionCopy {

    public static University[] reflectionCopy(University[] universities) throws CloneNotSupportedException {
        long startTime = System.nanoTime();

        Generator generator = new Generator();
        int universitiesLength = universities.length;
        int facultiesLength = universities[0].getFaculties().length;
        int studentsLength = universities[0].getFaculties()[0].getStudents().length;
        University[] universitiesToReturn = generator.generate(universitiesLength, facultiesLength, studentsLength);
        fieldCopy(universities, universitiesToReturn);
        long endTime = System.nanoTime();

        System.out.println("\nReflection");
        printTime(endTime - startTime);
        return universitiesToReturn;
    }

    public static <T> void fieldCopy(T from, T to) {
        if (from.getClass().isArray()) {
            int length = Array.getLength(from);
            for (int i = 0; i < length; i ++) {
                fieldCopy(Array.get(from, i), Array.get(to, i));
            }
        }
        else {
            for (Field f : from.getClass().getFields()) {
                try {
                    if (isPrimitivish(f.getType())) {
                        f.set(to, f.get(from));
                    } else {
                        fieldCopy(f.get(from), f.get(to));
                    }
                } catch (IllegalArgumentException | IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static boolean isPrimitivish(Class c) {
        return c.isPrimitive() || c == String.class || c == Boolean.class
                || c == Byte.class || c == Short.class || c == Character.class
                || c == Integer.class || c == Float.class || c == Double.class
                || c == Long.class || c == LocalDate.class;
    }

    public static void printTime(Long time){
        System.out.println("Time in nanoseconds: " + (time));
        System.out.println("Time in miliseconds: " + ((double)(time))/1000000);
        System.out.println("Time in seconds: " + ((double)(time))/1000000000);
    }
}
