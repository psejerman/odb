import java.util.List;

public class ODB {

    public static void create(Object object){
        Container container = new Container(object.getClass()).read();
        List list = container.getList(object.getClass());

        list.add(object);

        container.create();


    }
    public void read(){


    }
    public void update(){

    }
    public void delete(){


    }
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
}
