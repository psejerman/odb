import java.io.File;
import java.io.Reader;
import java.net.URI;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class Main {


    public static void main(String[] args)
    {

        Vehicles Autos = new Vehicles();
        Autos.create();
        System.out.println(Autos.getSourceFile().toString());
        Timestamp ts = Timestamp.from(Instant.now());
    }
}