package de.project.odb;

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

    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", color='" + color + '\'' +
                '}';
    }
}

