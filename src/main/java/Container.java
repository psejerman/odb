import com.google.gson.Gson;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Container extends ArrayList implements CRUD{
    private Gson gson;
    private String elementType;
    private File containerFile;
    public Container () {
        this.gson = new Gson();
    }
    @Override
    public void create(Object data) {
        try {
            FileOutputStream fos = new FileOutputStream ("db/testfile.txt");
            ObjectOutputStream oos = new ObjectOutputStream (fos);
            oos.writeObject(data);
            oos.flush();
            oos.close();

            return ;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return;
    }

    //Create von Fynn
    /** Erstellt ein Container Objekt und schreibt persistente Daten auf die Festplatte
     * @author Fynn
     * @param  Object Container, String dateiname
     * @return void
     */
    public void create2(Object data, String nameOfData) {
        try {

            Writer writer = Files.newBufferedWriter(Paths.get("db/" + nameOfData));
            this.gson.toJson(data, writer);
            writer.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String read() {
        try {
            FileInputStream fis = new FileInputStream ("db/testfile.txt");
            ObjectInputStream ois = new ObjectInputStream (fis);
            String retrievedData = (String) ois.readObject();
            ois.close();
            return retrievedData;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //read von Fynn
    public Container read2(String nameOfData, String nameOfListObjects) {
        try {

            //Liest Datei
            Reader reader = Files.newBufferedReader(Paths.get("db/"+ nameOfData));
            //neuer Container
            Container container = new Container();
            //Datei hält Personen
            if(nameOfListObjects == "Person") {
                //Liste aus Datei in eine Liste aus Personen, um Personen zu erstellen
                List<Person> Persons = Arrays.asList(this.gson.fromJson(reader, Person[].class));
                //fügt die Personen-Objekte der Liste dem neuen Container hinzu
                for (int i = 0; i + 1 <= Persons.size(); i++) {
                    container.add(Persons.get(i));
                }
            } else
                //Datei hält Autos
                if(nameOfListObjects == "Auto") {
                    List<Auto> Autos = Arrays.asList(this.gson.fromJson(reader, Auto[].class));
                    //fügt die Personen-Objekte der Liste dem neuen Container hinzu
                    for (int i = 0; i + 1 <= Autos.size(); i++) {
                        container.add(Autos.get(i));
                    }
                }
            reader.close();
            return container;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public void update() {
        return ;
    }

    //ähnlich wie read2() Zunächst wird die Datei gelesen und die Liste wird mit dem neuen Attribut beschrieben
    public Container update2(String nameOfData, String nameOfListObjects, int numberOfUpdateTarget, String nameOfUpdateTarget, String nameOfUpdateValue) {
        try {

            //Liest Datei
            Reader reader = Files.newBufferedReader(Paths.get("db/"+ nameOfData));
            //neuer Container
            Container container = new Container();
            //Datei hält Personen
            if(nameOfListObjects == "Person") {
                //Liste aus Datei in eine Liste aus Personen, um Personen zu erstellen
                List<Person> Persons = Arrays.asList(this.gson.fromJson(reader, Person[].class));
                //Update des Objekts
                if(numberOfUpdateTarget+1 <= Persons.size()) {
                    if (nameOfUpdateTarget == "Vorname") {
                        Persons.get(numberOfUpdateTarget).setVorname(nameOfUpdateValue);
                    } else if (nameOfUpdateTarget == "Nachname") {
                        Persons.get(numberOfUpdateTarget).setNachname(nameOfUpdateValue);
                    }
                }
                //fügt die Personen-Objekte der Liste dem neuen Container hinzu
                for (int i = 0; i + 1 <= Persons.size(); i++) {
                    container.add(Persons.get(i));
                }
            } else
                //Datei hält Autos
                if(nameOfListObjects == "Auto") {
                    List<Auto> Autos = Arrays.asList(this.gson.fromJson(reader, Auto[].class));
                    //Update des Objekts
                    if(numberOfUpdateTarget+1 <= Autos.size()) {
                        if (nameOfUpdateTarget == "Farbe") {
                            Autos.get(numberOfUpdateTarget).setFarbe(nameOfUpdateValue);
                        }
                    }
                    //fügt die Personen-Objekte der Liste dem neuen Container hinzu
                    for (int i = 0; i + 1 <= Autos.size(); i++) {
                        container.add(Autos.get(i));
                    }
                }
            //alte Datei wird gelöscht, neue geschrieben
            this.delete2(nameOfData);
            this.create2(container, nameOfData);
            reader.close();
            return container;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void delete() {

    }

    //Die Datei mit dem eingegebenen Namen wird im Ordner db/ gelöscht
    public void delete2( String nameOfFile ) {
        File myObj = new File("db/" + nameOfFile);
        if (myObj.delete()) {
            System.out.println("Die Datei " + myObj.getName() + " wurde gelöscht!");
        } else {
            System.out.println("Die Datei konnte nicht gelöscht werden");
        }
    }
    /**
     * Liefert den Namen der im Container enthaltenen Elemente im Plural
     * @author peter
     * @return String Kindobjektname im Plural || null wenn Container leer
     **/

    public String getElementType() {
        if (this.size() >=  1) {
            return this.elementType = this.get(0).getClass().getSimpleName()+"s";
        }
        else return null;
    }

    /**
     * Liefert den absoluten Pfad der Zieldatei des serialisierten Objekts
     * @uthor Peter
     * @return String absoluter Dateipfad
     */
    public String getContainerFile() {
        return this.containerFile.getAbsolutePath();
    }

    /**
     * Legt den absoluten Pfad der Zieldatei des serialisierten Objekts anhand
     * des Objektnamens fest
     * @author Peter
     * @param -
     * @resturn void
     */
    public void setContainerFile() {
        this.containerFile = new File(this.getElementType());
    }
    //TODO Save Container to file
    //TODO Read Container from file
    //TODO Delete container->file
    //TODO Check if file exists



}

