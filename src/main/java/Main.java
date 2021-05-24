import java.io.File;
import java.io.Reader;
import java.net.URI;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Main {


    public static void main(String[] args) {
        Container Persons = new Container(new File("db/Persons"));
        Persons.add(new Person("Anne", "Müller"));
        Persons.add(new Person("Horst", "Maier"));
        Persons.create();

        //Container Autos = new Container();
        //Autos.read(Auto.class);
        //Reader reader = Files.newBufferedReader(Paths.get(this.getContainerFile()));
        Person test = new Person();

        //System.out.println(Persons.getContainerFile());
        //System.out.println(Persons.read().get(0).getClass().getSimpleName());






    }
}