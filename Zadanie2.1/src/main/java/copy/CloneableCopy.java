package copy;

import entity.University;

public class CloneableCopy {

    public static University[] cloneableCopy(University[] universities) throws CloneNotSupportedException {
        long startTime = System.nanoTime();

        University[] universitiesToReturn = new University[universities.length];
        for (int i = 0; i < universities.length; i++) {
            universitiesToReturn[i] = (University) universities[i].clone();
        }
        long endTime = System.nanoTime();

        System.out.println("\nCloneable");
        printTime(endTime - startTime);
        return universitiesToReturn;
    }

    public static void printTime(Long time){
        System.out.println("Time in nanoseconds: " + (time));
        System.out.println("Time in miliseconds: " + ((double)(time))/1000000);
        System.out.println("Time in seconds: " + ((double)(time))/1000000000);
    }
}
