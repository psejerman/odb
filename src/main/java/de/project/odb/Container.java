package de.project.odb;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * <h1>Container</h1>
 * <h3>Generischer Container zum verwalten der Listen</h3>
 *<p>Container ist in der Lage, mittels Nutzung der Storage-Klasse Listen flüchtig zu halten und zu verwalten, sowie
 * persistent in Dateien abhängig vom gehaltenen Objekttypen zu schreiben oder zu lesen.
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
     * @return Container        eigene Instanz zur weiteren Verwendung
     */
    public Container create() {
        Storage.getInstance().setFile(this.sourceFile).write(this.list);
        return this;
    }

    /**
     * Liest eine Liste aus persistentem Speicher und hält diese flüchtig zur Bearbeitung vor.
     * @return Container        eigene Instanz zur weiteren Verwendung
     */
    public Container read() {
        this.list = this.getList(this.type);
        return this;
    }

    /**
     * Löscht die verknüpfte persistente Datei.
     * @return Container        eigene Instanz zur weiteren Verwendung
     */
    public Container deleteFile () {
        Storage.getInstance().setFile(this.sourceFile).delete();
        return this;
    }

    /**
     * Fügt neues Objekt an verknüpfte flüchtige Liste an
     * @param object         An Liste anzufügendes Objekt
     * @param <Type>         Objekttyp
     */
    public <Type> void put(Type object) {
        this.list.add(object);
    }

    /**
     * Holt ein Objekt generischen Typs aus flüchtiger Liste und gibt es zurück
     * @param index     Index des entsprechenden Listenelements
     * @param <Type>    Objekttyp zum Casten der Rückgabe
     * @return          Objekt der Liste
     */
    public <Type> Type get(Class <Type> cls, int index) {
        return (Type)this.getList(cls).get(index);
    }

    /**
     * Gibt die vollständige flüchtig gehaltene Liste von Objekten generischen Typs zurück.
     * @param cls           Klassentyp auf den zugegriffen werden soll
     * @param <Type>        Objekttyp zum Casten der Rückgabe
     * @return              Gesamte liste von Objekten
     */
    public <Type>List<Type> getList(Class<Type> cls) {
        return ((List<Type>) Storage.getInstance().setFile(this.sourceFile).read());
    }

    /**
     * Überschreibt vollständige flüchtig gehaltene Liste.
     * @param list      Liste von Objekten zur Übername in flüchtigen Speicher
     */
    public void setList(List list) {
        this.list = list;
    }

    /**
     * Gibt den aktuellen Lese-/Speicherort des Containers zurück.
     * @return sourceFile       Dateiobjekt der Quelldatei des Containers
     */
    public File getSourceFile() {
        return this.sourceFile;
    }

    /**
     * Überschreibt den im Construktor generierten Default-Lese-/Speicherort des Containers
     * @param sourceFile        Dateiobjekt der Quelldatei des Containers
     */
    public void setSourceFile(File sourceFile) {
        this.sourceFile = sourceFile;
    }
}
