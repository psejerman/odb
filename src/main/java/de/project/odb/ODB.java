package de.project.odb;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
//TODO Kommentare


/**
 * <h1>ODB</h1>
 */
public class ODB {

    /**
     * @param object
     */
    public static void create(Object object) {
        Container container = new Container(object.getClass()).read();
        List list = container.getList(object.getClass());
        // Container put???
        list.add(object);
        container.setList(list);
        container.create();
    }

    /**
     * @param cls
     * @param index
     * @param <Type>
     * @return
     */
    public static <Type> Object read(Class<Type> cls, int index) {
        return new Container(cls).getList(cls).get(index);

    }

    /**
     * @param cls
     * @param <Type>
     * @return
     */
    public static <Type> List<Type> read(Class<Type> cls) {
        return new Container(cls).read().getList(cls);

    }

    /**
     * @param cls
     * @param index
     * @param arg1
     * @param attribute
     * @param <Type>
     */
    public static <Type> void update(Class cls, int index, Type arg1, String attribute) {
        Container container = new Container(cls);
        List list = container.getList(cls);
        Object object = list.get(index);
        String getMethod;

        String setMethod = "set" + attribute.substring(0, 1).toUpperCase() + attribute.substring(1);
        if (arg1.getClass() == Boolean.class) {
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
     *
     * @param cls
     * @param index
     * @return
     */
    public static boolean delete(Class cls, int index) {
        try {
            Container container = new Container(cls);
            List list = container.read().getList(cls);
            list.remove(index);
            container.setList(list);
            container.create();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Löscht je nach Angabe true/false nur die Liste einer persistent gespeicherten Datei oder die gesamte Datei.
     * Hierzu greift delete() auf delete() der Klasse Container zu
     *
     * @param cls
     * @param removeSourceFile
     */
    public static void delete(Class cls, boolean removeSourceFile) {
        Container container = new Container(cls);
        if (!removeSourceFile) {
            container.setList(new ArrayList<>());
            container.create();
        } else container.deleteFile();
    }

    /**
     * @param cls
     * @param print
     * @return
     */
    public static List getAll(Class cls, boolean print) {
        //Syntaktischer Zucker!!!
        List list = new Container(cls).getList(cls);

        if (print) {
            for (int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i).toString());
            }
        }
        return list;
    }

    /**
     * @param cls
     * @param methodName
     * @param contains
     * @param <Type>
     * @return
     */
    public static <Type> List<Type> bla(Class<Type> cls, String methodName, String contains) {
        Container container = new Container(cls);
        List<Type> list = container.getList(cls);
        List<Type> result = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            try {
                Object object = new Container(cls).read().getList(cls).get(i);
                Method method = cls.getMethod("get" + methodName.substring(0, 1).toUpperCase() + methodName.substring(1));
                if (method.invoke(object) == contains) {
                    result.add((Type) object);
                }
            } catch (SecurityException | NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        System.out.println(result.size());
        return result;
    }

    /**
     * @param cls
     * @param methodName
     * @param contains
     * @param <Type>
     * @return
     */
    public static <Type> List<Type> search(Class<Type> cls, String methodName, String contains) {
        Container container = new Container(cls);
        List<Type> list = container.getList(cls);
        List<Type> results = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            try {
                Object object = new Container(cls).read().getList(cls).get(i);
                Method method = cls.getMethod("get" + methodName.substring(0, 1).toUpperCase() + methodName.substring(1));
                String result = (String) method.invoke(object);

                if (result.equals(contains)) {
                    results.add((Type) object);
                }
            } catch (SecurityException | NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        return results;
    }
}