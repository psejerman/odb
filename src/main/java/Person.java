import java.util.List;

public class Person extends Dataset{
    private String Vorname;
    private String Nachname;
    //private int id;
    public Person(){
        super.setId();
    }
    public Person(String vorname, String nachname) {
        super.setId();
        Vorname = vorname;
        Nachname = nachname;
    }


    public Container create() {
        Container Con = new Container();
        return Con;
    }

    public List<Object> read(){

        return null;
    }


    public void update() {

    }


    public void delete() {

    }

    @Override
    public String toString() {
        return "Person{" +
                "Vorname='" + Vorname + '\'' +
                ", Nachname='" + Nachname + '\'' +
                ", id=" + super.getId() +
                '}';
    }

    public String getVorname() {
        return Vorname;
    }

    public void setVorname(String vorname) {
        Vorname = vorname;
    }

    public String getNachname() {
        return Nachname;
    }

    public void setNachname(String nachname) {
        Nachname = nachname;
    }


}