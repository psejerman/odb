import java.io.Serializable;
import java.util.UUID;


public class Dataset implements Serializable {


    // TODO Set uniq id?
    private UUID id;

    public void setId() {
        this.id = UUID.randomUUID();
    }

    public UUID getId() {
        return id;
    }

    // TODO Read Dataset

    // TODO Add new Dataset
    // TODO Change existing Dataset
    // TODO Find Dataset by Attribute
    // TODO Delete Dataset
}

