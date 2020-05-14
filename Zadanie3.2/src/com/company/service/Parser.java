package com.company.service;

import com.company.enumerator.Flag;
import com.company.enumerator.Type;
import com.company.model.NameValue;
import com.company.model.TypePair;

import java.util.*;
import java.util.stream.Collectors;

public class Parser {
    private Generator generator;
    private String className;
    private ArrayList<NameValue> classParams = new ArrayList<>();
    private ArrayList<String> classFlags = new ArrayList<>();

    public Parser(Generator generator) {
        this.generator = generator;
    }

    public void parse(String string){
        classParams.clear();
        classFlags.clear();
        if (string.split("\\s+").length > 1){
                String[] splited = string.split("\\s+");
                try {
                    detectClass(splited[0], splited[1]);
                    detectParams(splited);
                    detectFlags(splited);
                    generator.generateClassCode(className, classParams, classFlags);
                    System.out.println("\n###########################CODE###########################");
                    System.out.println(generator.getClassString());
                    System.out.println("###########################CODE###########################\n");
                } catch (Exception ex) {
                    Manager.handleError(ex.getMessage());
                }
            } else {
                try {
                    throw new IllegalArgumentException("Command not recognized!");
                } catch ( Exception ex) {
                    Manager.handleError(ex.getMessage());
                }
            }
    }

    private void detectClass(String createName, String name) throws IllegalArgumentException {
        if(createName.equals("create")){
            if(!Character.isDigit(name.charAt(0))){
                this.className = name;
            } else {
                throw new IllegalArgumentException("Class name is invalid!");
            }
        }else {
            throw new IllegalArgumentException("Statement does not starts with create word!");
        }
    }

    private void detectParams(String[] splited) throws IllegalArgumentException{
        Set<String> names = new HashSet<>();
        ArrayList<TypePair> values = new ArrayList<>();

        for(int i = 2; i < splited.length; i++) {
            if(splited[i].startsWith("--")){
                break;
            } else {
                if (splited[i].endsWith(":") && !Character.isDigit(splited[i].charAt(0))) {
                    names.add(splited[i].substring(0, splited[i++].length() - 1));
                } else {
                    throw new IllegalArgumentException("Parameter name is invalid!");
                }
                TypePair typePair = null;
                for (Type value: Type.values()) {
                    if ( i < splited.length && splited[i].endsWith(",")) {
                        String key = splited[i].substring(0, splited[i].length() - 1);
                        if (key.equals(value.getType())) {
                            typePair = new TypePair(key, null);
                        }
                    } else if (i < splited.length && splited[i].equals(value.getType())) {
                        String key = splited[i++];
                        if ( i < splited.length && splited[i].equals("=")) {
                            String v = splited[++i];
                            if(v.endsWith(",")){
                                v = v.substring(0, splited[i].length() - 1);
                                typePair = new TypePair(key, v);
                            } else {
                                typePair = new TypePair(key, v);
                            }
                        } else {
                            typePair = new TypePair(key, null);
                        }
                    }
                }
                if (typePair != null) {
                    values.add(typePair);
                } else {
                    throw new IllegalArgumentException("Type of parameter is invalid!");
                }
            }
        }

        if(names.size() == values.size()){
            for (int i = 0; i < names.size(); i++) {
                this.classParams.add(new NameValue((String) names.toArray()[i], values.get(i)));
            }
        } else {
        throw new IllegalArgumentException("Incorrect syntax or duplicated field names!");
        }
    }

    private void detectFlags(String[] splited) throws IllegalArgumentException{
        List<String> flags = Arrays.stream(splited).filter(string -> string.startsWith("--")).collect(Collectors.toList());
        flags.forEach(flag -> {
            int size = classFlags.size();
            Arrays.stream(Flag.values()).forEach(flag1 -> {
                if(flag1.getFlag().equals(flag.substring(2))){
                    this.classFlags.add(flag.substring(2));
                }
            });
            if(size == classFlags.size()) {
                throw new IllegalArgumentException("Flag is invalid!");
            }
        });
    }
}
