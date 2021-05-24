import java.io.File;
import java.io.Reader;
import java.net.URI;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {


    public static void main(String[] args) {

        Container persons = new Container();
        persons.put(new Person("Horst", "Mayer"));
        persons.put(new Person("Kurt", "Müller"));

        persons.create();

        List test = persons.read(Person[].class);
        System.out.println(test.get(0));


















    }
}