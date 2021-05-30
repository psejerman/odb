package de.project.odb;

public class Customer extends Person{

    private int customerID;

    public Customer(int customerID, String vorname, String nachname) {
        this.customerID = customerID;
        super.setVorname(vorname);
        super.setNachname(nachname);
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }
}
