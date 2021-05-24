public class Auto extends Dataset{
    private String farbe;

    public Auto() {
        super();
    }

    public Auto(String farbe) {
        this.farbe = farbe;
    }

    public String getFarbe() {
        return farbe;
    }

    public void setFarbe(String farbe) {
        this.farbe = farbe;
    }

    @Override
    public String toString() {
        return "Auto{" +
                "farbe='" + farbe + '\'' +
                '}';
    }
}