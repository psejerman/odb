import java.net.URI;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {


    public static void main(String[] args) {
        Container Persons = new Container();
        Persons.add(new Person("Anne", "Müller"));
        Persons.add(new Person("Horst", "Maier"));
        Persons.create2(Persons, "Persons");

        Persons.setContainerFile();
        System.out.println(Persons.getContainerFile());






    }
}