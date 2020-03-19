package com.company;

import com.company.controller.Controller;
import com.company.model.SalesModel;

public class Main {

    public static void main(String[] args) {
        SalesModel salesModel = new SalesModel();
        Controller controller = new Controller(salesModel);
    }
}
