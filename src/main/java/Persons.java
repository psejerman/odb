import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Persons extends Container{

    public Persons() {

    }

    public List<Person> read() {
        return  (List<Person>) Storage.getInstance().setFile(super.sourceFile).read();
    }

    public void update() {}

    public int getCountOfEntries() {
        return this.getList().size();
    }


    public void setPersonList(List<Person> personList) {
        super.setList(personList);
    }

    @Override
    public List<Person> getList() {
        return (List<Person>)super.getList();
    }
}
