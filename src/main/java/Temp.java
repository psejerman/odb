import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
public class Temp {
// TODO • Erstellen
// TODO • Bearbeiten
// TODO • Lesen
// TODO • Löschen

    public class CRUD {
        private String filePath;
        private String fileName;
        /*
         * Abstrakte implementierung des CRUD Models
         * Grundlage für alle Datenbankentitäten
         */

        protected void setFileName(String fileName) {
            this.fileName = fileName;
        }
        protected void setFilePath(String filePath) {
            this.filePath = filePath;
        }

        /**
         *
         * @param Data
         */
        public void create(Object[] Data) throws Exception{
            FileOutputStream fos = new FileOutputStream (this.filePath + this.fileName);
            ObjectOutputStream oos = new ObjectOutputStream (fos);
            oos.writeObject(Data);
            oos.flush();
            oos.close();
        }

        public Object read() throws IOException, ClassNotFoundException{
            FileInputStream fis = new FileInputStream (this.fileName);
            ObjectInputStream ois = new ObjectInputStream (fis);
            Object retrievedData = ois.readObject();
            ois.close();
            return retrievedData;
        }


        public void update(){}
        public void delete() {

        }
    }

    /*
    Save File:
    String filename = "myfile.txt";

    Vector v = new Vector(10.0f, 20.0f);
    Gson gson = new Gson();
    String s = gson.toJson(v);

    FileOutputStream outputStream;

    try {
      outputStream = openFileOutput(filename, Context.MODE_PRIVATE);
      outputStream.write(s.getBytes());
      outputStream.close();
    } catch (Exception e) {
      e.printStackTrace();
    }

    Read File:
     FileInputStream fis = context.openFileInput("myfile.txt", Context.MODE_PRIVATE);
     InputStreamReader isr = new InputStreamReader(fis);
     BufferedReader bufferedReader = new BufferedReader(isr);
     StringBuilder sb = new StringBuilder();
     String line;
     while ((line = bufferedReader.readLine()) != null) {
         sb.append(line);
     }

     String json = sb.toString();
     Gson gson = new Gson();
     Vector v = gson.fromJson(json, Vector.class);

     */


}
