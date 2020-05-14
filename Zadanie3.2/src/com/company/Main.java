package com.company;

import com.company.service.Generator;
import com.company.service.Manager;
import com.company.service.Parser;

public class Main {

    public static void main(String[] args) {
        Generator generator = new Generator();
        Parser parser = new Parser(generator);
        Manager manager = new Manager(parser);
        manager.initMenu();
    }
}
