class CarTest {
    public static void main(String[] args) {
    
        // Create a new car, and assign it some values
        Car client1Car = new Car();
        // client1Car.year = 2001;
        // client1Car.setMake("Honda");
        // client1Car.setModel("Civic");
        // client1Car.color = "white";
    
        // Create another new car, and assign it some values
        Car client2Car = new Car(2018, "Mazda", "CX-3", "navy");
        // client2Car.year = 2018;
        // client2Car.setMake("Mazda");
        // client2Car.setModel("CX-3");
        // client2Car.color = "navy";
    
        // Now they have their own individual data stored together.
        System.out.println("Car 1 make: " + client1Car.getMake());
        System.out.println("Car 1 model: " + client1Car.getModel());
    
    	System.out.println("Car 2 make: " + client2Car.getMake());
        System.out.println("Car 2 model: " + client2Car.getModel());
    }
}