public class Person implements CRUD{
    private String Vorname;
    private String Nachname;
    private long id;
    public Person(long id, String vorname, String nachname) {
        id = id;
        Vorname = vorname;
        Nachname = nachname;
    }

    @Override
    public void create(Object object) {

    }

    @Override
    public void read() {

    }

    @Override
    public void update() {

    }

    @Override
    public void delete() {

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
