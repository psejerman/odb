package de.project.odb;

public class Main {

    public static void main(String[] args) {

    ODBTest test = new ODBTest();

    test.babyCreateTest();
    test.personCreateTest();
    test.vehicleCreateTest();
    test.customerCreateTest();

    test.getAllTest();

    test.updateAllTest();

    test.searchAllTest();

    test.deleteTypeTests();


    }
}