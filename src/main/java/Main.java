import java.lang.reflect.Type;

public class Main {




    public static void main(String[] args) {
        Baby henno = new Baby("henno", 1);
        Baby horst = new Baby("Horst", 2);

        ODB.create(horst);
        //ODB.create(horst);


        ODB.getAll(Baby.class, true);


    }
}