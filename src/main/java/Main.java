import javax.naming.event.ObjectChangeListener;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Locale;

public class Main {

    public static void main(String[] args) {
        Baby henno = new Baby("henno", 1);
        Baby horst = new Baby("Horst", 2);

        //ODB.create(henno);
        //ODB.create(horst);

        //ODB.getAll(Baby.class, true);

        //List list = henno.getAttributes();
        //System.out.println(list.get(3));
        //ODB.update(Baby.class,0,"Klara","name");

        //ODB.read(Baby.class);
        System.out.println(ODB.search(Baby.class,"name", "Maja").get(0));





    }
}