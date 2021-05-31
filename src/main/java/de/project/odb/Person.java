package de.project.odb;
/**
 * <h1>Person</h1>
 * <h3>Testklasse</h3>
 * <p>Beispiel-Klasse zum Testen der Grundfunktionen von ODB. Kann durch jede andere klasse ersetzt werden
 * Besitzt Basisattribute und Standardsetter und Standardgetter</p>
 */

public class Person extends Dataset{
    private String Vorname;
    private String Nachname;
    public Person(){

    }
    public Person(String vorname, String nachname) {
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