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
            FileOutputStream fos = new FileOutputStream ("db/testfile.txt");
            ObjectOutputStream oos = new ObjectOutputStream (fos);
            oos.writeObject(data);
            oos.flush();
            oos.close();

            return ;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return;
    }

    @Override
    public String read() {
        try {
            FileInputStream fis = new FileInputStream ("db/testfile.txt");
            ObjectInputStream ois = new ObjectInputStream (fis);
            String retrievedData = (String) ois.readObject();
            ois.close();
            return retrievedData;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
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
