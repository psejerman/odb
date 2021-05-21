import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Container extends ArrayList implements CRUD{
    @Override
    public void create(Object data) {
        try {
            FileOutputStream fos = new FileOutputStream ("testfile.txt");
            ObjectOutputStream oos = new ObjectOutputStream (fos);
            oos.writeObject(data);
            oos.flush();
            oos.close();

            return ;
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void read() {
        return ;
    }

    @Override
    public void update() {
        return ;
    }

    @Override
    public void delete() {

    }

    //TODO Save Container to file
    //TODO Read Container from file
    //TODO Delete container->file
    //TODO Check if file exists



}
