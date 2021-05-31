package de.project.odb;

/**
 * <h1>Baby</h1>
 * <h3>Testklasse</h3>
 * <p>Beispiel-Klasse zum Testen der Grundfunktionen von ODB. Kann durch jede andere klasse ersetzt werden
 * Besitzt Basisattribute und Standardsetter und Standardgetter</p>
 */

public class Baby extends Dataset{
    private String name;
    private int age;
    private boolean funny;

    public Baby() {

    }

    public Baby(String name, Integer age, boolean funny) {
        this.name = name;
        this.age = age;
        this.funny = funny;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isFunny() {
        return funny;
    }

    public void setFunny(boolean funny) {
        this.funny = funny;
    }
}
