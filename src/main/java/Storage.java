import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * <h1>Serializer/Deserializer Klasse</h1>
 * <p>Singleton Klasse zum Schreiben/Lesen von persistenten Daten
 * Setzt serializable implementierung voraus</p>
 * <b>Wichtig:</b> <p></p>Vor Schreibzugriff setFile() nutzen!</p>
 *
 * @author  Peter
 * @version 1.0.1
 * @since   25.05.2021
 */

public class Storage {
    private static Storage INSTANCE = null;
    private File file;
    private Path storagePath;

    /**
     * Erstellt Instanz von Storage oder gibt bestehende Instanz zurück
     * @return Storage: Instanz des Singleton-Objekts
     */
    public static Storage getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Storage();
        }
        return INSTANCE;
    }

    public Storage() {
        // Default Speicherordner
        this.storagePath = Paths.get("db").toAbsolutePath();

    }

    /**
     * Schreibt eine Liste von Objekten persistent auf die Festplatte
     * @param List list: Liste von zuspeichernden Objekten
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
    }

    /**
     * Liest eine Liste von Objekten aus persistentem Speicher
     * und gibt diese zurück (ein Cast in den Richtigen Typ ist notwendig)
     * @return List retrievedData: Liste von gelesenen Objekten
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
        return this.file;
    }

    /**
     * Setzt Datei in die serialisierte Objekte geschrieben werden als
     * absoluten Pfad, erstellt ggf neue datei
     * @param File Zieldatei
     * @return Storage: Gibt Singelton zur weiteren Nutzung zurück
     */

    public Storage setFile(File file) {
        this.setStoragePath(this.storagePath);

        this.file = new File(storagePath.toString(),file.toString());
        if(!(this.file.exists() && Files.isRegularFile(this.file.toPath()))) {
            try {
                Files.createFile(this.file.toPath());
                this.write(new ArrayList<>());
            } catch (Exception e) {
                System.out.println("Datei " + this.file.toString() + " konnte nicht erstellt werden");
            }
        }
        return this;
    }

    /**
     * Löscht Datei mit allen Objekten des entsprechenden Typs
     * @return boolean: Fehler = False Erfolg = True
     */
    public boolean delete() {

        if(Files.isRegularFile(this.file.toPath())) {
            try {
                return this.file.delete();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    /**
     * Setzt den Speicherort für serialisierte Objekte fest erstellt einen
     * neuen Ordner wenn nciht vorhanden.
     * @param Path storagePath: Pfad zum Ablageordner für serialisierte Objekte
     * @return Storage Gibt Singelton zur weiteren Nutzung zurück
     */

    public Storage setStoragePath(Path storagePath) {
            try {
                Files.createDirectories(storagePath);
            }
            catch (IOException e) {
                System.out.println("Speicherverzeichnis konnte nicht angelegt werden");
            }
        this.storagePath = storagePath.toAbsolutePath();
        return this;
    }

    public Path getStoragePath() {
        return storagePath.toAbsolutePath();
    }

}
