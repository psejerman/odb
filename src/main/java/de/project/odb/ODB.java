package de.project.odb;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * <h1>ODB</h1>
 * <h3>Klasse zur Implementierung in bestehende Anwendungen</h3>
 * <p>Die ODB-Klasse enthält statische Methoden, welche ohne eine Instanziierung nutzbar sind.
 * Es sind die CRUD-Operationen, sowie eine Suche mit Klasse und Attribut als Parameter implementiert.
 * Die ODB-Klasse stellt ein Abstraktionslayer zur Verfügung welches alle von Dataset abgeleiteten Objekte verarbeiten
 * kann. Dafür nutzt ODB die Container-Klasse
 * Benutzung:
 * <code>ODB.read(Klasse, index)</code>
 * <code>ODB.read(Klasse)</code>
 * <code>ODB.create()</code>
 * <code>ODB.delete()</code>
 * <code>ODB.update(Klasse, index, neuer Wert, Attribut)</code>
 * </p>
 * <b>Wichtig:</b> <p>Getter- und Setternamen müssen den Attributnamen der zu verarbeitenden Objekte entsprechen
 * Bsp: Attribut : name - setName, getName bei boolean isName</p>
 */
public class ODB {

    /**
     * Fügt der Datenbank ein Objekt hinzu.
     * @param object    Objekt das gespeichert werden soll
     */
    public static void create(Object object){
        Container container = new Container(object.getClass()).read();
        List list = container.getList(object.getClass());
        list.add(object);
        container.setList(list);
        container.create();
    }

    /**
     * Holt ein Objekt der Parameter-Klasse nach index und gibt es Zurück
     * @param cls       Klassentyp auf den zugegriffen werden soll
     * @param index     Index des Objektes in der Liste
     * @param <Type>    Objekttyp zum Casten der Rückgabe
     * @return          Objekt des Typs Type
     */
    public static <Type> Type read(Class <Type> cls, int index){
        Type object = new Container(cls).get(cls, index);
        return object;
    }

    /**
     * Holt eine Liste aller, dem Parameter entsprechenden Objekte
     * @param cls       Klassentyp auf den zugegriffen werden soll
     * @param <Type>    Objekttyp zum Casten der Rückgabe
     * @return list     Liste des Typs Type
     */
    public static <Type>List<Type> read(Class<Type> cls){
        List<Type> list = new Container(cls).read().getList(cls);
        return list;

    }

    /**
     * Aktualisiert Attributwerte entsprechend der übergebenen Parameter
     * @param cls       Klassentyp auf den zugegriffen werden soll
     * @param index     Index des Objektes in der Liste
     * @param arg1      einzufügender neuer Attributwert
     * @param attribute Name des zu manipulierenden Attributs
     * @param <Type>    Objekttyp zum Casten der Rückgabe
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
        } catch (SecurityException | NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
        container.setList(list);
        container.create();
    }

    public static <Type> void updateById(Class cls, String id, Type arg1, String attribute){
        Container container = new Container(cls);
        List list = container.getList(cls);
        Object object = list.get(searchForPoisition(cls, id));
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
     * @param cls       Klassentyp auf den zugegriffen werden soll
     * @param index     Index des Objektes in der Liste
     * @return          <code>true</code> Wenn Löschung erfolgreich
     *                  <code>false</code> bei Fehler
     */
    public static boolean delete(Class cls, int index){
        try {
            Container container = new Container(cls);
            List list = container.read().getList(cls);
            list.remove(index);
            container.setList(list);
            container.create();
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
     * @param cls               Klassentyp auf den zugegriffen werden soll
     * @param removeSourceFile  <code>true</code> wenn die Datei ebenfalls zu löschen
     *                          <code>false</code> wenn die Datei geleert aber belassen werden soll
     */
    public static void delete(Class cls, boolean removeSourceFile){
        Container container = new Container(cls);
        if(!removeSourceFile) {
            container.setList(new ArrayList<>());
            container.create();
        }
        else container.deleteFile();
    }

    /**
     * Gibt alle Objekte des Parameter-Typs in die Konsole aus
     * @param cls       Klassentyp auf den zugegriffen werden soll
     * @param print     <code>true</code> für Ausgabe in der Konsole und return der Liste
     *                  <code>false</code> return der Liste ohne Konsolenausgabe
     */
    public static void getAll(Class  cls, boolean print) {
        //Syntaktischer Zucker!!!
        List list = new Container(cls).getList(cls);

        if (print) {
            for (int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i).toString());
            }
        }
    }

    /**
     * Durchsucht Datenbankeinträge des Parameter-Klassen-Typs, gibt alle Objekte zurück dessen Parameter-Attribut
     * mit dem Parameter-Pattern übereinstimmt
     * @param cls           Klassentyp auf den zugegriffen werden soll
     * @param attribute     Attribut das auf Suchmuster überprüft wird
     * @param pattern       Suchmuster
     * @param <Type>        Objekttyp zum Casten der Rückgabe
     * @return              Liste von Funden gemäß Parametern
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
        return results;
    }

    public static <Type>int searchForPoisition(Class<Type> cls, String id){
        Container container = new Container(cls);
        List <Type>list = container.getList(cls);
        List <Type>results = new ArrayList<>();
        for(int i = 0; i<list.size(); i++) {
            try {
                Object object = new Container(cls).read().getList(cls).get(i);
                Method method = cls.getMethod("getId");
                String result = method.invoke(object).toString();

                if(result.equals(id)) {
                    return i;
                }
            } catch (SecurityException | NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return -1;
    }
}
