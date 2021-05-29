package de.project.odb;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.UUID;


public class Dataset implements Serializable{
    private static final long serialVersionUID = 1L;
    protected UUID id;

    public Dataset() {
        this.id = UUID.randomUUID();

    }

    public void setId() {
        this.id = UUID.randomUUID();
    }

    public UUID getId() {
        return id;
    }

    /**
     * Gibt alle Attribute der abgeleiteten Klassen und die Dataset UUID formatiert aus
     * @retun string Objektattribute
     */
    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        String newLine = System.getProperty("line.separator");
        string.append("Objekt: " + this.getClass().getSimpleName() +": UUID = " + this.getId());
        string.append(newLine);
        for (Field field : this.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            String name = field.getName();
            Object value = null;
            try {
                value = field.get(this);
            } catch (IllegalArgumentException | IllegalAccessException e) {
                e.printStackTrace();
            }
            string.append("-> "+name + ": "+ value);
            string.append(newLine);
        }
        return string.toString();
    }

}


