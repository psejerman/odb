package de.project.odb;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {

    public static void main(String[] args) {
        Baby henno = new Baby("henno", 1, true);
        Baby horst = new Baby("Horst", 2, false);

        ODB.create(henno);
        ODB.create(horst);

        ODB.update(Baby.class, 0, 5, "age");
        ODB.update(Baby.class, 1, true, "funny");

        ODB.getAll(Baby.class, true);




        //ODB.getAll(Baby.class, true);

        //List list = henno.getAttributes();
        //System.out.println(list.get(3));
        //ODB.update(Baby.class,0,"Klara","name");

        //ODB.read(Baby.class);
        //System.out.println(ODB.search(Baby.class,"name", "Maja").get(0));





    }
}