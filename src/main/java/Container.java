import java.io.File;
import java.util.List;

public class Container {

    private File sourceFile;
    private Class type;
    private List list;

    public Container(Class type) {

        this.type = type;
        this.sourceFile = new File(type.getSimpleName() + "s");
    }

    public void create() {
        Storage.getInstance().setFile(this.sourceFile).write(this.list);
    }

    public Container read() {
        this.list = this.getList(this.type);
        return this;
    }

    public void deleteFile () {
        Storage.getInstance().setFile(this.sourceFile).delete();
    }

    public <T> void put( T value) {
        list.add(value);
    }

    public <T> T get(int i) {
        return (T) list.get(i);
    }

    public <Type>List<Type> getList(Class<Type> cls) {
        return ((List<Type>) Storage.getInstance().setFile(this.sourceFile).read());
    }

    public void setList(List list) {
        this.list = list;
    }

    public File getSourceFile() {
        return sourceFile;
    }

    public void setSourceFile(File sourceFile) {
        this.sourceFile = sourceFile;
    }
}
