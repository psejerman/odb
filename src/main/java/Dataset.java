import java.io.Serializable;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.UUID;


public class Dataset implements Serializable{
    private static final long serialVersionUID = 1L;
    protected UUID id;
    protected Timestamp createDate = Timestamp.from(Instant.now());
    protected Timestamp updateDate;

    public Dataset() {


    }

    public void setId() {
        this.id = UUID.randomUUID();
    }

    public UUID getId() {
        return id;
    }


}

