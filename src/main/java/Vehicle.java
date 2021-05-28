public class Vehicle extends Dataset{

    private String color;

    public Vehicle() {
        super();
    }

    public Vehicle(String farbe) {
        this.color = farbe;
    }

    public String getFarbe() {
        return color;
    }

    public void setFarbe(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Auto{" +
                "farbe='" + color + '\'' +
                '}';
    }
}

