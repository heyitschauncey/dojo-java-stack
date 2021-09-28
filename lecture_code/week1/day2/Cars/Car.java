class Car {
    private int year;
    private String make;
    private String model;
    private String color;

    public Car() {
        this.year = 2018;
        this.make = "Subaru";
        this.model = "WRX";
        this.color = "Space Gray";
    }

    public Car(int year, String make, String model, String color) {
        this.year = year;
        this.make = make;
        this.model = model;
        this.color = color;
    }
    
    // getter
    public int getYear() {
        return this.year;
    }
    // setter
    public void setYear(int year) {
        this.year = year;
    }

    public String getMake() {
        return this.make;
    }

    public void setMake(String make)  {
        this.make = make;
    }

    public String getModel() {
        return this.model;
    }

    public void setModel(String asdf) {
        this.model = asdf;
    }

}
