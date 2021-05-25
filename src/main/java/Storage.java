import java.io.*;
import java.util.List;

/**
 * <h1>Serializer/Deserializer Klasse</h1>
 * <p>Singleton Klasse zum Schreiben/Lesen von persistenten Daten
 * Setzt serializable implementierung voraus</p>
 * <b>Wichtig:</b> <p></p>Vor Schreibzugriff setFile() nutzen!</p>
 *
 * @author  Peter
 * @version 1.0
 * @since   25.05.2021
 */

public class Storage {
    private static Storage INSTANCE = null;
    private File file;

    public static Storage getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Storage();
        }
        return INSTANCE;
    }

    public Storage() {

    }

    /**
     * Schreibt eine Liste von Objekten persisten auf die Festplatte
     * @author Peter
     * @param list list - Liste von Objekten
     * @return void
     */
    public void write(List list) {
        try {
            FileOutputStream fos = new FileOutputStream (this.file);
            ObjectOutputStream oos = new ObjectOutputStream (fos);
            oos.writeObject(list);
            oos.flush();
            oos.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return;

    }

    /**
     * Liest eine Liste von Objekten aus persistentem Speicher aus
     * und gibt diese zurück (ein Cast in den Richtigen Typ ist notwendig)
     * @author Peter
     * @param -
     * @return List retrieved Data - Liste von gelesenen Objekten
     */
    public List read() {
        try {
            FileInputStream fis = new FileInputStream(this.file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Object retrievedData = ois.readObject();
            ois.close();
            return (List)retrievedData;
        } catch (Exception e) {
            e.printStackTrace();
        }

         return null;
    }

    public File getFile() {
        return file;
    }

    public Storage setFile(File file) {
        this.file = file;
        return this;
    }
}
