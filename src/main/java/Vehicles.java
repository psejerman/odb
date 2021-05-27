import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Vehicles extends Container{

    public Vehicles() {

    }

    public List<Vehicle> read() {
        return (List<Vehicle>) Storage.getInstance().setFile(super.sourceFile).read();
    }

}
