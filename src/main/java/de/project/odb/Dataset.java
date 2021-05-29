package de.project.odb;

import java.io.Serializable;
import java.util.UUID;

// TODO Kommentare
// TODO toString für agbeleietete Klassen
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

    @Override
    public String toString() {
        return "Dataset{" +
                "id=" + id +
                '}';
    }
}


