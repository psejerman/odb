package de.project.odb;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.UUID;


/**
 * <h1>Dataset</h1>
 * <h3>Basiseigenschaften eines Datensatzes</h3>
 * Die Dataset-Klasse stellt die grundlegenden Eigenschaften eines Datensatzes sowie das Serializable-Interface zur
 * Verfügung. Sie vererbt den abgeleiteten Datensätzen eine eindeutige generierte ID, stellt die Versionierung beim
 * Serialisieren von Objekten (serialVersionUID) sicher und ermöglicht die Ausgabe von Abgeleiteten objekten in die
 * Konsole mittels toString Override
 */


public class Dataset implements Serializable{
    private static final long serialVersionUID = 1L;
    protected UUID id;

    public Dataset() {
        this.id = UUID.randomUUID();

    }

    /**
     * Generiert eindeutige Id mittels UUID Objekt
     */
    public void setId() {
        this.id = UUID.randomUUID();
    }

    /**
     * Liefert die eindeutige Id des Objekts zurück
     * @return      UUID des objekts
     */
    public UUID getId() {
        return id;
    }

    /**
     * Gibt alle Attribute der abgeleiteten Klassen und die Dataset UUID formatiert aus
     * @retun string        Objektattribute
     */
    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        String newLine = System.getProperty("line.separator");
        string.append("Objekt: " + this.getClass().getSimpleName() +": UUID = " + this.getId());
        string.append(newLine);
        Class<?> cls = this.getClass();
        while(true) {
            for (Field field : cls.getDeclaredFields()) {
                field.setAccessible(true);
                String name = field.getName();
                Object value = null;
                try {
                    value = field.get(this);
                } catch (IllegalArgumentException | IllegalAccessException e) {
                    e.printStackTrace();
                }
                string.append("-> " + name + ": " + value);
                string.append(newLine);
            }
            if(cls.getSuperclass() == Dataset.class || cls.getSuperclass() == null){
                break;
            }
            cls = cls.getSuperclass();
        }
        return string.toString();
    }
}


