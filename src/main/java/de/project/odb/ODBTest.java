package de.project.odb;
import java.util.List;

/**
 * <h1>ODBTest</h1>
 * <h3>Test-Klasse</h3>
 * <p>ODBTest enthält Methoden zur Demonstration der CRUD-, sowie Suchfunktion von ODB</p>
 */

public class ODBTest {

    public void personCreateTest() {
        System.out.println("Teste create(): Personen werden Angelegt");
        Person horst = new Person("Horst", "Mailer");
        Person klaus = new Person("Klaus", "Müller");
        Person anne = new Person("Anne", "Bar");
        Person helmut = new Person("Helmut", "Bar");
        ODB.create(horst);
        ODB.create(klaus);
        ODB.create(anne);
        ODB.create(helmut);
    }
    public void babyCreateTest() {
        System.out.println("Teste create(): Babys werden Angelegt");
        Baby fynn = new Baby("Fynn", 1, false);
        Baby pia = new Baby("Pia", 2, true);
        Baby peter = new Baby("Peter", 3, true);
        ODB.create(fynn);
        ODB.create(pia);
        ODB.create(peter);
        System.out.println("Fertig");
    }
    public void vehicleCreateTest() {
        System.out.println("Teste create(): Vehicles werden Angelegt");
        Vehicle ford = new Vehicle("white");
        Vehicle nissan = new Vehicle("red");
        Vehicle renault = new Vehicle("green");
        ODB.create(ford);
        ODB.create(nissan);
        ODB.create(renault);
        System.out.println("Fertig");
    }
    public void customerCreateTest() {
        System.out.println("Teste create(): Customer werden Angelegt");
        Customer customer1 = new Customer(1,"Lasse","Bluten");
        Customer customer2 = new Customer(2,"Lassma","Ballernsson");
        ODB.create(customer1);
        ODB.create(customer2);

        System.out.println("Fertig");
    }
    public void getAllTest() {
        System.out.println("Teste getAll(): Alle vorab geschriebenen Objekte werden deserialisiert");
        ODB.getAll(Person.class, true);
        ODB.getAll(Baby.class, true);
        ODB.getAll(Vehicle.class, true);
        ODB.getAll(Customer.class, true);
        System.out.println("Test Fertig");
    }
    public void updateAllTest() {
        System.out.println("Teste update() auf Alle Beispielklassen:");

        System.out.println("Vorher:");
        System.out.println(ODB.read(Person.class,0).toString());
        ODB.update(Person.class, 0, "Horstensen", "nachname");
        System.out.println("Nachher:");
        System.out.println(ODB.read(Person.class,0).toString());
        System.out.println("--------------------------------------------------------------");

        System.out.println("Vorher:");
        System.out.println(ODB.read(Baby.class,0).toString());
        ODB.update(Baby.class, 0, true, "funny");
        System.out.println("Nachher:");
        System.out.println(ODB.read(Baby.class,0).toString());
        System.out.println("--------------------------------------------------------------");

        System.out.println("Vorher:");
        System.out.println(ODB.read(Vehicle.class,2).toString());
        ODB.update(Vehicle.class, 2, "powderblue", "color");
        System.out.println("Nachher:");
        System.out.println(ODB.read(Vehicle.class,2).toString());
        System.out.println("--------------------------------------------------------------");

        System.out.println("Test Fertig");
    }
    public void searchAllTest() {
        System.out.println("Teste search() auf Alle Beispielklassen:");
        System.out.println("Suche Person mit Nachnamen Bar");
        List<Person> personsFound = ODB.search(Person.class, "nachname", "Bar");
        System.out.println("Anzahl Funde: " + personsFound.size());
        System.out.println("Funde:");
        for (Person person : personsFound) {
            person.toString();
        }
        System.out.println("--------------------------------------------------------------");

        List<Baby> babysFound = ODB.search(Baby.class, "name", "Piahontass");
        System.out.println("Anzahl Funde: " + babysFound.size());
        System.out.println("Funde:");
        for (Baby baby : babysFound) {
            baby.toString();
        }
        System.out.println("--------------------------------------------------------------");

        List<Vehicle> vehiclesFound = ODB.search(Vehicle.class, "color", "red");
        System.out.println("Anzahl Funde: " + vehiclesFound.size());
        System.out.println("Funde:");
        for (Vehicle vehicle : vehiclesFound) {
            vehicle.toString();
        }
        System.out.println("--------------------------------------------------------------");

        System.out.println("Test Fertig");
    }
    public void deleteTypeTests() {
        System.out.println("Teste delete() auf Alle Beispielklassen und alle Varianten:");
        System.out.println("--------------------------------------------------------------");

        System.out.println("Alle Personen inklusive persistenten Speicher werden Gelöscht, Siehe Speicherort der Persons-Datei");
        ODB.delete(Person.class, true);

        System.out.println("Alle Babys exclusive persistenten Speicher werden Gelöscht");
        System.out.println("Vorher:");
        System.out.println("Anzahl Objekte" + ODB.read(Baby.class).size());
        ODB.delete(Baby.class, false);
        System.out.println("Anzahl Objekte" + ODB.read(Baby.class).size());

        System.out.println("Lösche das Objekt des Typs Vehicle mit index 1");
        System.out.println("Vorher:");
        System.out.println("Anzahl Objekte" + ODB.read(Vehicle.class).size());
        ODB.delete(Vehicle.class, 1);

        System.out.println("Test Fertig");
    }
}
