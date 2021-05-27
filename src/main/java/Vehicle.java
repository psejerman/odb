public class Vehicle {

    public class Auto extends Dataset{
        private String color;

        public Auto() {
            super();
        }

        public Auto(String farbe) {
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
}
