package com.company;
import java.lang.reflect.InvocationTargetException;


public class Main {


    public static void main(String[] args) throws CloneNotSupportedException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        //Generic object
        String string = new GenericObject<String>(String.class).getObject();
        System.out.println(string.getClass());

        Person person = new GenericObject<Person>(Person.class).getObject();
        System.out.println(person.getClass());

//        Integer integer = new GenericObject<Integer>(Integer.class).getObject();
//        System.out.println(integer.getClass());

        //Generic array
        String[] stringArray = new GenericArray<String>(String[].class, 10).getArray();
        System.out.println("\n" + stringArray.getClass());
        System.out.println(stringArray.length);

        Person[] personArray = new GenericArray<Person>(Person[].class, 20).getArray();
        System.out.println(personArray.getClass());
        System.out.println(personArray.length);

        Integer[] integerArray = new GenericArray<Integer>(Integer[].class, 30).getArray();
        System.out.println(integerArray.getClass());
        System.out.println(integerArray.length);

        // Clone
        Pair<String> firstPair = new Pair("first", "second");
        Pair pairCloned = (Pair) firstPair.clone();
        System.out.println("\n" + pairCloned.getClass());
        System.out.println(pairCloned.getFirst().getClass());
        System.out.println(pairCloned.getSecond().getClass());

        Pair<Integer> secondPair = new Pair(1, 2);
        Pair pairCloned2 = (Pair) secondPair.clone();
        System.out.println("\n" + pairCloned2.getClass());
        System.out.println(pairCloned2.getFirst().getClass());
        System.out.println(pairCloned2.getSecond().getClass());

        Pair<String> thirdPair = new Pair(new Person(), new Person());
        Pair pairCloned3 = (Pair) thirdPair.clone();
        System.out.println("\n" + pairCloned3.getClass());
        System.out.println(pairCloned3.getFirst().getClass());
        System.out.println(pairCloned3.getSecond().getClass());
    }
}
