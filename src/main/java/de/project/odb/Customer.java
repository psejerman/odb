package de.project.odb;

/**
 * <h1>Customer</h1>
 * <h3>Testklasse</h3>
 * <p>Beispiel-Klasse(Ableitung 2.Grades) zum Testen der Grundfunktionen von ODB. Kann durch jede andere klasse ersetzt werden
 * Besitzt Basisattribute und Standardsetter und Standardgetter</p>
 */
public class Customer extends Person{

    private int customerID;

    public Customer(int customerID, String vorname, String nachname) {
        super(vorname, nachname);
        this.customerID = customerID;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }
}
