package de.project.odb;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {

    public static void main(String[] args) {
        Baby henno = new Baby("henno", 1, true);
        Baby horst = new Baby("Horst", 2, false);

        ODB.create(henno);
        ODB.create(horst);

        System.out.println(ODB.read(Baby.class,0).toString());










    }
}