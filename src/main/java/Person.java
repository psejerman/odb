public class Person extends Dataset implements CRUD{
    private String Vorname;
    private String Nachname;
    //private int id;
    public Person(/*int id, */String vorname, String nachname) {
        super.setId();
        Vorname = vorname;
        Nachname = nachname;
    }

    @Override
    public void create(Object object) {

    }

    @Override
    public String read(){

        return null;
    }

    @Override
    public void update() {

    }

    @Override
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