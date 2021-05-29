package de.project.odb;

public class ODBTest {

    public void personCreateTest() {
        Person horst = new Person("Horst", "Mailer");
        Person klaus = new Person("Klaus", "Müller");
        Person anne = new Person("Anne", "Bar");
        Person helmut = new Person("Helmut", "Bar");
        ODB.create(horst);
        ODB.create(klaus);
        ODB.create(anne);
        ODB.create(helmut);
    }

    public void bebyCreateTest() {
        Baby fynn = new Baby("Fynn", 1, false);
        Baby pia = new Baby("Pia", 2, true);
        Baby peter = new Baby("Peter", 3, true);
        ODB.create(fynn);
        ODB.create(pia);
        ODB.create(peter);
    }
    public void vehicleCreateTest() {
        Vehicle ford = new Vehicle("white");
        Vehicle nissan = new Vehicle("red");
        Vehicle renault = new Vehicle("green");
        ODB.create(ford);
        ODB.create(nissan);
        ODB.create(renault);
    }
    public void getAllTest() {
        ODB.getAll(Person.class, true);
        ODB.getAll(Baby.class, true);
        ODB.getAll(Vehicle.class, true);
    }
    public void updateAllTest() {
        ODB.update(Person.class, 0, "Horstensen", "nachname");
        ODB.update(Baby.class, 0, true, "funny");
        ODB.update(Vehicle.class, 2, "powderblue", "color");
    }
    public void searchAllTest() {
        ODB.search(Person.class, "nachname", "Bar");
        ODB.search(Baby.class, "name", "Piahontass");
        ODB.search(Vehicle.class, "color", "red");
    }
    public void deleteTypeTests() {
            ODB.delete(Person.class, true);
        ODB.delete(Baby.class, false);
        ODB.delete(Vehicle.class, 1);
    }
}
