import com.google.gson.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
public class Main {


    public static void main(String[] args) {
        Person testPerson = new Person(1,"Klaus", "Mayer");
        Auto testAuto = new Auto();
        ODB myDatabase = new ODB();

        Container Persons = new Container();
        Container Autos = new Container();

        Autos.add(testAuto);
        System.out.println(Persons.size());

        Persons.add(testPerson);
        Persons.add(new Person(2,"Klaus","Müller"));


        System.out.println(Persons.size());

        Gson gson = new Gson();
        Persons.create(gson.toJson(Persons));
        //String jsonString = (new Container()).read();
        //System.out.println(jsonString);

        Container test = gson.fromJson((new Container()).read(), Container.class);
        System.out.println(test.get(0).toString());
        System.out.println(Persons.get(0).toString());




    }
}