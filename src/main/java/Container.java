import java.io.File;
import java.util.List;

/**
 * <h1>Containere</h1>
 * <h6>Generischer Container zum verwalten der Listen</h6>
 *<p>Container ist in der Lage mittels nutzung der Storage-Klasse Listen flüchtig zu halten und zu verwalten.
 * Es besteht die Möglichkeit generische Objekte aus listen zu entnehmen oder diese anzufügen.
 * Die klasse verwaltet des weiteren die Lese-/Schreibzugriffe auf den persistenten Speicher und ermöglicht die Verwaltung der
 * Ziel-/Quelldateien.</p>
 * @version 1.0.2
 * @since   25.05.2021
 */
public class Container {

    private File sourceFile;
    private Class type;
    private List list;

    public Container(Class type) {

        this.type = type;
        this.sourceFile = new File(type.getSimpleName() + "s");
    }

    /**
     * Speichert die in den Attributen enthaltene Liste persistent.
     * @return Container: eigene instanz zur weiteren Verwendung
     */
    public Container create() {
        Storage.getInstance().setFile(this.sourceFile).write(this.list);
        return this;
    }

    /**
     * Liest eine Liste aus persistentem Speicher und hält diese flüchtig zur Bearbeitung vor.
     * @return eigene instanz zur weiteren Verwendung
     */
    public Container read() {
        this.list = this.getList(this.type);
        return this;
    }

    /**
     * Löscht die verknüfte persistente Datei.
     * @return eigene instanz zur weiteren Verwendung
     */
    public Container deleteFile () {
        Storage.getInstance().setFile(this.sourceFile).delete();
        return this;
    }

    /**
     * Fügt neues objekt an verknüpfte flüchtige Liste an
     * @param value
     * @param <Type>
     */
    public <Type> void put(Type value) {
        list.add(value);
    }

    /**
     * Holt ein Objekt generischen Typs aus flüchtiger liste und gibt es zurück
     * @param index
     * @param <Type>
     * @return
     */
    public <Type> Type get(int index) {
        return (Type) list.get(index);
    }

    /**
     * Gibt die vollständige flüchtig gehaltene Liste von Objekten generischen Typs zurück.
     * @param cls
     * @param <Type>
     * @return
     */
    public <Type>List<Type> getList(Class<Type> cls) {
        return ((List<Type>) Storage.getInstance().setFile(this.sourceFile).read());
    }

    /**
     * Überschreibt vollständige flüchtig gehaltene Liste
     * @param list
     */
    public void setList(List list) {
        this.list = list;
    }

    /**
     * Gibt den aktuellen Lese-/Speicherort des Containers zurück.
     * @return File
     */
    public File getSourceFile() {
        return sourceFile;
    }

    /**
     * Überschreibt den im Construktor generierten Default-Lese-/Speicherort des Containers
     * @param sourceFile
     */
    public void setSourceFile(File sourceFile) {
        this.sourceFile = sourceFile;
    }
}
