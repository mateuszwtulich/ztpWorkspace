package com.company;

import com.company.controller.*;
import com.company.model.*;

public class Main {

    public static void main(String[] args) {
        SalesModel salesModel = new SalesModel();
        Controller controller = new Controller(salesModel);
    }
}
