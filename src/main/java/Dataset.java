import java.io.Serializable;

import java.util.UUID;


public class Dataset implements Serializable{
    private static final long serialVersionUID = 1L;
    protected UUID id;

    public Dataset() {


    }

    public void setId() {
        this.id = UUID.randomUUID();
    }

    public UUID getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Dataset{" +
                "id=" + id +
                '}';
    }

    /*public  List<Field> getAttributes() {
        Class cls = this.getClass();
        List<Field> fields = new ArrayList<>();
        do {
            Collections.addAll(fields, cls.getDeclaredFields());
            cls = cls.getSuperclass();
        } while (cls != null);
        return fields;
    }*/
}

