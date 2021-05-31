package de.project.odb;
/**
 * <h1>Vehicle</h1>
 * <h3>Testklasse</h3>
 * <p>Beispiel-Klasse zum Testen der Grundfunktionen von ODB. Kann durch jede andere klasse ersetzt werden
 * Besitzt Basisattribute und Standardsetter und Standardgetter</p>
 */

public class Vehicle extends Dataset{

    private String color;

    public Vehicle() {
    }

    public Vehicle(String farbe) {
        this.color = farbe;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

}

