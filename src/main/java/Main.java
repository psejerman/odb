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


    public static void main(String[] args)
    {
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("Horst", "Mayer"));
        personList.add(new Person("Anne", "Brandt"));


        List<Auto> autoList  = new ArrayList<>();
        Auto volvo = new Auto();
        Auto volkswagen = new Auto();
        autoList.add(volvo);
        autoList.add(volkswagen);
        Storage.getInstance().setFile(new File("db/Autos")).write(autoList);
        Auto gelesen = (Auto)Storage.getInstance().setFile(new File("db/Autos")).read().get(0);
        Storage.getInstance().setFile(new File("db/Persons")).write(personList);

    }
}