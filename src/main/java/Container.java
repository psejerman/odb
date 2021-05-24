import com.google.gson.Gson;
import com.google.gson.JsonElement;
import java.lang.reflect.Type;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.List;

public class Container implements Serializable{
    private Gson gson;
    private File containerFile;
    private List list = new ArrayList<>();


    public Container() {
        this.gson = new Gson();


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

    public List read(Class cls) {
    //public Object read () {
       try {
           String fileName = "db/Persons";
           FileInputStream fis = new FileInputStream(fileName);
           ObjectInputStream ois = new ObjectInputStream(fis);
           List retrievedData = Arrays.asList(ois.readObject(),cls.getClass());
           ois.close();
           return retrievedData;


        } catch (Exception e) {
            e.printStackTrace();
        }
       return null;

    }




}

