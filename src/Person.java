public class Person {
    private String Vorname;
    private String Nachname;
    private long id;
    public Person(long id, String vorname, String nachname) {
        id = id;
        Vorname = vorname;
        Nachname = nachname;
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
