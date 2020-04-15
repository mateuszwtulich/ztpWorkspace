package copy;

import entity.University;

import java.io.*;

public class SerializationCopy {

    public static University[] serializationCopy(University[] universities) throws IOException, ClassNotFoundException {
        long startTime = System.nanoTime();

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(bos);
        out.writeObject(universities);

        ByteArrayInputStream bis = new   ByteArrayInputStream(bos.toByteArray());
        ObjectInputStream in = new ObjectInputStream(bis);
        University[] universitiesToReturn = (University[]) in.readObject();
        long endTime = System.nanoTime();

        System.out.println("\nSerialization");
        printTime(endTime - startTime);
        return universitiesToReturn;
    }

    public static void printTime(Long time){
        System.out.println("Time in nanoseconds: " + (time));
        System.out.println("Time in miliseconds: " + ((double)(time))/1000000);
        System.out.println("Time in seconds: " + ((double)(time))/1000000000);
    }
}
