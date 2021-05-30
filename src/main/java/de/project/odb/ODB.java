package de.project.odb;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * <h1>ODB</h1>
 * <h3>Klasse zur Implementierung in bestehende Anwendungen</h3>
 * <p>Die ODB-Klasse enthält statische Methoden, welche ohne eine Instanziierung nutzbar sind.
 * Es sind die CRUD-Operationen, sowie eine Suche mit Klasse und Attribut als Parameter implementiert.
 * Die ODB-Klasse stellt ein Abstraktionslayer zur Verfügung welches alle von Dataset abgeleiteten Objekte verarbeiten
 * kann. Dafür nutzt ODB die Container-Klasse
 * Benutzung:
 * ODB.read(Klasse, index)
 * ODB.read(Klasse)
 * ODB.create()
 * ODB.delete()
 * ODB.update(Klasse, index, neuer Wert, Attribut)
 * </p>
 * <b>Wichtig:</b> <p>Getter- und Setternamen müssen den Attributnamen der zu verarbeitenden Objekte entsprechen
 * Bsp: Attribut : name - setName, getName bei boolean isName</p>
 */
public class ODB {

    /**
     * Fügt der Datenbank ein Objekt hinzu.
     * @param object
     */
    public static void create(Object object){
        Container container = new Container(object.getClass()).read();
        List list = container.getList(object.getClass());
        list.add(object);
        container.setList(list);
        container.create();
        System.out.println("\nDie Datei " + object.getClass().getSimpleName() + "s wurde erstellt!\n");
    }

    /**
     * Holt ein Objekt der Parameter-Klasse nach index und gibt es Zurück
     * @param cls
     * @param index
     * @param <Type>
     * @return object
     */
    public static <Type> Type read(Class <Type> cls, int index){
        Type object = new Container(cls).get(cls, index);
        return object;
    }

    /**
     * Holt eine Liste aller, dem Parameter entsprechenden Objekte
     * @param cls
     * @param <Type>
     * @return
     */
    public static <Type>List<Type> read(Class<Type> cls){
        List<Type> list = new Container(cls).read().getList(cls);
        return list;
    }

    /**
     * Aktualisiert Attributwerte entsprechend der übergebenen Parameter
     * @param cls Typ des zu manipulierenden Objekts
     * @param index
     * @param arg1 einzufügender neuer Attributwert
     * @param attribute Name des zu manipulierenden Attributs
     * @param <Type>
     */
    public static <Type> void update(Class cls, int index, Type arg1, String attribute){
        Container container = new Container(cls);
        List list = container.getList(cls);
        Object object = list.get(index);
        String getMethod;

        String setMethod = "set" + attribute.substring(0,1).toUpperCase() + attribute.substring(1);
        if(arg1.getClass() == Boolean.class) {
            getMethod = "is" + attribute.substring(0, 1).toUpperCase() + attribute.substring(1);
        } else {
            getMethod = "get" + attribute.substring(0, 1).toUpperCase() + attribute.substring(1);
        }
        try {
            Method get = cls.getMethod(getMethod);
            Method set = cls.getMethod(setMethod, get.getReturnType());
            set.invoke(object, arg1);
            System.out.println("\nDie Datei " + cls.getSimpleName() + "s wurde aktualisiert!\n");
        } catch (SecurityException | NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
        container.setList(list);
        container.create();
    }

    /**
     * Löscht das in index angegebene Element der Liste mit den Objekten der Klasse cls.
     * Hierzu hält die Funktion die Liste flüchtig, löscht ein Element und überschreibt die Datei mit der aktuallisierten
     * Version der Liste.
     * @param cls
     * @param index
     * @return
     */
    public static boolean delete(Class cls, int index){
        try {
            Container container = new Container(cls);
            List list = container.read().getList(cls);
            list.remove(index);
            container.setList(list);
            container.create();
            System.out.println("Der Eintrag " + index + " in der Liste " + cls.getSimpleName() + "s wurde gelöscht!\n");
            return true;
        }
        catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Löscht je nach Angabe true/false nur die Liste einer persistent gespeicherten Datei oder die gesamte Datei.
     * Hierzu greift delete() auf delete() der Klasse Container zu
     * @param cls
     * @param removeSourceFile
     */
    public static void delete(Class cls, boolean removeSourceFile){
        Container container = new Container(cls);
        if(!removeSourceFile) {
            container.setList(new ArrayList<>());
            container.create();
            System.out.println("\nDie Liste wurde aus der Datei " + cls.getSimpleName() + "s gelöscht!\n");
        }
        else container.deleteFile();
        System.out.println("\nDie Datei " + cls.getSimpleName() + "s wurde gelöscht!\n");
    }

    /**
     * Gibt alle Objekte des Parameter-Typs in die Konsole aus
     * @param cls
     * @param print
     */
    public static void getAll(Class  cls, boolean print) {
        //Syntaktischer Zucker!!!
        List list = new Container(cls).getList(cls);

        if (print) {
            System.out.println("\nDer Inhalt der Datei " + cls.getSimpleName() + "s ist:\n\n");
            for (int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i).toString());
            }
        }
    }

    /**
     * Durchsucht Datenbankeinträge des Parameter-Klassen-Typs, gibt alle Objekte zurück dessen Parameter-Attribut
     * mit dem Parameter-Pattern übereinstimmt
     * @param cls
     * @param attribute
     * @param pattern
     * @param <Type>
     * @return
     */
    public static <Type>List<Type> search(Class<Type> cls, String attribute, String pattern){
        Container container = new Container(cls);
        List <Type>list = container.getList(cls);
        List <Type>results = new ArrayList<>();
        for(int i = 0; i<list.size(); i++) {
            try {
                Object object = new Container(cls).read().getList(cls).get(i);
                Method method = cls.getMethod("get" + attribute.substring(0, 1).toUpperCase() + attribute.substring(1));
                String result = (String) method.invoke(object);

                if(result.equals(pattern)) {
                    results.add((Type)object);
                }
            } catch (SecurityException | NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        System.out.println("\nFolgende Einträge mit dem Inhalt " + pattern + " in der Datei " + cls.getSimpleName() + "s wurden gefunden:\n\n");
        return results;
    }
}

