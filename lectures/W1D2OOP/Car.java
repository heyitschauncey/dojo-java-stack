public class Car {
    // Member Variables (aka attribute)
    private int year;
    private String make;
    private String model;
    private String color;
    private int numberOfWheels;

    private static int numberOfCars = 0;

    // Constructors
    public Car() {
        this.year = 1977;
        this.make = "Toyota";
        this.model = "Celica";
        this.color = "red";
        this.numberOfWheels = 4;
        numberOfCars++;
    }

    // public Car(int year, String make, String model, String color) {
    //     this.year = year;
    //     this.make = make;
    //     this.model = model;
    //     this.color = color;
    //     // this.numberOfWheels = 4;
    // }

    public Car(int yearParam, String makeParam, String modelParam,
               String colorParam) {
        year = yearParam;
        make = makeParam;
        model = modelParam;
        color = colorParam;
        numberOfWheels = 4;
        numberOfCars++;
    }

    public Car(int year, String make, String model, String color,
               int numberOfWheels) {
        this.year = year;
        this.make = make;
        this.model = model;
        this.color = color;
        this.numberOfWheels = numberOfWheels;
        numberOfCars++;
    }

    public void drive() { System.out.println("Vroom Vroom."); }

    public int getYear() { return this.year; }
    public void setYear(int newYear) { this.year = newYear; }

    public String getMake() { return this.make; }
    public void setMake(String make) { this.make = make; }

    public String getModel() { return this.model; }
    public void setModel(String model) { this.model = model; }

    public String getColor() { return this.color; }
    public void setColor(String color) {
        if (color.equals("brown")) {
            System.out.println("No dont do that");
        } else {
            this.color = color;
        }
    }

    public int getNumberOfWheels() { return this.numberOfWheels; }

    public static int getNumberOfCars() { return numberOfCars; }
}
