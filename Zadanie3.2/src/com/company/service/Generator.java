package com.company.service;

import com.company.enumerator.Flag;
import com.company.model.NameValue;

import java.io.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Generator {
    private String classString;
    private final static Logger logger =
            Logger.getLogger(Generator.class.getName());

    public void generateClassCode(String name, ArrayList<NameValue> params, ArrayList<String> flags){
        classString = "public class " + name + " {\n";
        handleParams(params);
        handleFlags(name, params, flags);
        classString += "\n}";

        for (String flag: flags) {
            if (flag.equals(Flag.SAVE.getFlag())) {
                try {
                    saveClassToFile(name);
                    System.out.println("\nFile " + name + ".java saved!");
                } catch (IOException e) {
                    logger.log(Level.SEVERE, e.getMessage(), e);
                    e.printStackTrace();
                }
            }
        }
    }

    private void handleParams(ArrayList<NameValue> params){
        for (NameValue param : params) {
            classString += "\tprivate " + param.getTypePair().getName() + " " + param.getName();
            if(param.getTypePair().getValue() != null){
                classString += " = " + param.getTypePair().getValue();
            }
            classString += ";\n";
        }
    }

    private void handleFlags(String name, ArrayList<NameValue> params, ArrayList<String> flags){
        for (String flag: flags) {
            if(flag.equals(Flag.GETTERS.getFlag())){
                for (NameValue param : params) {
                    classString += "\n\tpublic " + param.getTypePair().getName() + " get" + param.getName().substring(0,1).toUpperCase()
                            + param.getName().substring(1) + "() {";
                    classString += "\n\t\treturn " + param.getName() + ";\n\t}\n";
                }
            }
            if(flag.equals(Flag.SETTERS.getFlag())){
                for (NameValue param : params) {
                    classString += "\n\tpublic void set" + param.getName().substring(0,1).toUpperCase()
                            + param.getName().substring(1) + "("+ param.getTypePair().getName() + " " + param.getName() + ") {";
                    classString += "\n\t\tthis." + param.getName() + " = " + param.getName() + ";\n\t}\n";
                }
            }
            if(flag.equals(Flag.BUILDER.getFlag())) {
                classString += "\n\tprivate " + name + "(" + name.substring(0, 1).toUpperCase()
                        + name.substring(1) + "Builder builder) {";
                for (NameValue param : params) {
                    classString += "\n\t\tthis." + param.getName() + " = builder." + param.getName() + ";";
                }
                classString += "\n\t}";

                classString += "\n\n\tpublic static class " + name + "Builder {\n";
                for (NameValue param : params) {
                    classString += "\t\tprivate " + param.getTypePair().getName() + " " + param.getName();
                    if (param.getTypePair().getValue() != null) {
                        classString += " = " + param.getTypePair().getValue();
                    }
                    classString += ";\n";
                }
                classString += "\n\t\tpublic " + name + "Builder() {\n\t\t}";

                for (NameValue param : params) {
                    classString += "\n\n\t\t" + name + "Builder " + param.getName() + "(" + param.getTypePair().getName() + " " + param.getName() + ") {";
                    classString += "\n\t\t\tthis." + param.getName() + " = " + param.getName() + ";\n\t\t\treturn this;\n\t\t}";
                }

                classString += "\n\n\t\tpublic " + name + " build(){\n\t\t\treturn new " + name + "(this);\n\t\t}\n\t}";
            }
        }
    }

    public void saveClassToFile(String name) throws IOException {
        File file = new File( "assets",name + ".java");
        file.createNewFile();
        try (FileWriter out = new FileWriter(file)) {
            BufferedWriter writer = new BufferedWriter(out);
            writer.write(classString);
            writer.close();
        }
    }

    public String getClassString() {
        return classString;
    }


}
