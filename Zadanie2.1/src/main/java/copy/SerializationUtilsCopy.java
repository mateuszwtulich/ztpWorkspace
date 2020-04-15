package copy;

import entity.University;
import org.apache.commons.lang3.SerializationUtils;

public class SerializationUtilsCopy {
    public static University[] serializationUtilsCopy(University[] universities) throws CloneNotSupportedException {
        long startTime = System.nanoTime();

        University[] universitiesToReturn = (University[]) SerializationUtils.clone(universities);
        long endTime = System.nanoTime();

        System.out.println("\nSerializationUtils");
        printTime(endTime - startTime);
        return universitiesToReturn;
    }

    public static void printTime(Long time){
        System.out.println("Time in nanoseconds: " + (time));
        System.out.println("Time in miliseconds: " + ((double)(time))/1000000);
        System.out.println("Time in seconds: " + ((double)(time))/1000000000);
    }
}
