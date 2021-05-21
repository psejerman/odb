import com.google.gson.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello I am ODB");

        Person testPerson = new Person(1,"Klaus", "Mayer");
        Auto testAuto = new Auto();
        ODB myDatabase = new ODB();

        Container Persons = new Container();
        Container Autos = new Container();

        Autos.add(testAuto);
        System.out.println(Persons.size());

        Persons.add(testPerson);
        Persons.add(new Person(2,"HKlaus","Müller"));

        System.out.println(Persons.size());

        Gson gson = new Gson();
        Persons.create(gson.toJson(Persons));




    }
}