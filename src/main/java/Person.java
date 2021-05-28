
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
        return "Person:" +
                "Vorname='" + Vorname + '\'' +
                ", Nachname='" + Nachname + '\'' +
                ", id=" + super.getId() +
                '}';
    }
    public void printData() {
        System.out.println("Person:");
        System.out.println("--------------------------------:");
        System.out.println("id:" + super.getId());
        System.out.println("Vorname:" + Vorname);
        System.out.println("Vorname:" + Nachname);
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