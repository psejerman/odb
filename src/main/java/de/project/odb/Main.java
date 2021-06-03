package de.project.odb;


import java.util.UUID;

public class Main {

    public static void main(String[] args) {

    ODBTest test = new ODBTest();

    test.bebyCreateTest();
    test.personCreateTest();
    test.vehicleCreateTest();
    test.custmerCreateTest();

    test.getAllTest();

    test.updateAllTest();

    test.searchAllTest();

    test.deleteTypeTests();


    }
}