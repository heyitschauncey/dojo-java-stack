public class CarTest {
    public static void main(String[] args) {
        // datatype  variable = new class invokation
        Car car1 = new Car();
        Car car2 = new Car(2024, "Toyota", "Supra", "yellow");
        Car car3 = new Car(2024, "Toyota", "Supra", "yellow");
        Car car4 = new Car(2024, "Toyota", "Supra", "yellow");
        Car car5 = new Car(2024, "Toyota", "Supra", "yellow");
        Car car6 = new Car(2024, "Toyota", "Supra", "yellow", 4, "12356");

        // car1.year = 1977;
        // car1.make = "Toyota";
        // car1.model = "Celica";
        // car1.color = "red";
        // car1.setYear(2024);
        // car1.setMake("Toyota");
        // car1.setModel("Supra");
        // car1.setColor("yellow");

        System.out.println(car1);

        System.out.println(car1.getYear());
        System.out.println(car1.getModel());
        System.out.println(car1.getMake());
        System.out.println(car1.getColor());
        System.out.println(car2.getYear());
        System.out.println(car2.getModel());
        System.out.println(car2.getMake());
        System.out.println(car2.getColor());

        System.out.println(car2.getNumberOfWheels());

        System.out.println(Car.getNumberOfCars());

        System.out.println(car6.getVinNumber());
    }
}
