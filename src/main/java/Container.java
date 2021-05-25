import com.google.gson.Gson;
import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.List;

public class Container<Type> implements Serializable{
    private Gson gson;
    private File containerFile;
    private Class<Type> type;
    private List list = new ArrayList<>();


    public Container() {
        this.gson = new Gson();
    }
    public Container(Class <Type> type) {
        this.gson = new Gson();
        this.type = type;
    }

    public <T> void put( T value) {

      list.add(value);

    }
    public <T> T get(int key) {

        return (T)list.get(key);
    }

    /** Erstellt ein Container Objekt und schreibt persistente Daten auf die Festplatte
     * @author Fynn
     * @param -
     * @return Container Datensätze
     */
    public List create() {
        try {
            FileOutputStream fos = new FileOutputStream ("db/Persons");
            ObjectOutputStream oos = new ObjectOutputStream (fos);
            oos.writeObject(this.list);
            oos.flush();
            oos.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return this.list;
    }

    /**
     *
     * @return
     */

    public List read() {
    /*
       try {
           String fileName = "db/Persons";
           FileInputStream fis = new FileInputStream(fileName);
           ObjectInputStream ois = new ObjectInputStream(fis);
           Object retrievedData = (type.getClass().getSimpleName() + .class)ois.readObject();
           ois.close();
           System.out.println(retrievedData.);


           return retrievedData;


        } catch (Exception e) {
            e.printStackTrace();
        }*/
       return null;

    }




}

