import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import java.util.ArrayList;
import java.util.List;
//TODO Kommentare
//TODO Delete ganze Liste

public class ODB {

    public static void create(Object object){
        Container container = new Container(object.getClass()).read();
        List list = container.getList(object.getClass());
        // Container put???
        list.add(object);
        container.setList(list);
        container.create();
    }

    public static <Type>Object read(Class<Type> cls, int index){
        return new Container(cls).getList(cls).get(index);

    }

    public static <Type>List<Type> read(Class<Type> cls){
        return new Container(cls).read().getList(cls);

    }

    public static <Type> void update(Class cls, int index, Type arg1, String attribute){
        Container container = new Container(cls);
        List list = container.getList(cls);
        Object object = list.get(index);

        String methodName = "set" + attribute.substring(0,1).toUpperCase() + attribute.substring(1);
        try {
            Method method = cls.getMethod(methodName, arg1.getClass());
            method.invoke(object, arg1);
        } catch (SecurityException | NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
        container.setList(list);
        container.create();
    }

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
     *
     * @param cls
     * @param removeSourceFile
     */
    public static void delete(Class cls, boolean removeSourceFile){
        if(!removeSourceFile) new Container(cls).setList(new ArrayList<>());
        else new Container(cls).deleteFile();
    }

    /**
     *
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
    public static <Type>List<Type> bla(Class<Type> cls, String methodName, String contains){
        Container container = new Container(cls);
        List<Type> list = container.getList(cls);
        List <Type>result = new ArrayList<>();

        for(int i = 0; i<list.size(); i++) {
            try {
                Object object =  new Container(cls).read().getList(cls).get(i);
                Method method = cls.getMethod("get" + methodName.substring(0, 1).toUpperCase() + methodName.substring(1));
                if(method.invoke(object) == contains) {
                    result.add((Type)object);
                }
            } catch (SecurityException | NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        System.out.println(result.size());
        return result;
    }
    public static <Type>List<Type> search(Class<Type> cls, String methodName, String contains){
        Container container = new Container(cls);
        List <Type>list = container.getList(cls);
        List <Type>results = new ArrayList<>();
        //result.clear();
        //result.clear();
        for(int i = 0; i<list.size(); i++) {
            try {
                Object object = new Container(cls).read().getList(cls).get(i);
                Method method = cls.getMethod("get" + methodName.substring(0, 1).toUpperCase() + methodName.substring(1));
                //Method method = cls.getMethod("getName");
                String result = (String) method.invoke(object);

                if(result.equals(contains)) {
                    results.add((Type)object);
                }
            } catch (SecurityException | NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        return results;
    }
}

