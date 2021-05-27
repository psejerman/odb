import java.io.File;

import java.util.ArrayList;
import java.util.List;

public class Container {

    protected File sourceFile = new File(this.getClass().getSimpleName());;
    private List list = new ArrayList<>();
    public void create() {
        Storage.getInstance().setFile(this.sourceFile).write(this.list);
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

    public List getList() {
        return list;
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
