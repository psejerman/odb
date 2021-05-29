package de.project.odb;

public class Person extends Dataset{
    private String Vorname;
    private String Nachname;
    public Person(){

    }
    public Person(String vorname, String nachname) {
        super.setId();
        Vorname = vorname;
        Nachname = nachname;
    }




    public Person read(){



        return null;
    }


    public Person update() {
        return null;
    }


    public void delete() {

    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", Vorname='" + Vorname + '\'' +
                ", Nachname='" + Nachname + '\'' +
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