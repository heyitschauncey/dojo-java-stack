public class Greeting {
    // OVERLOADED
    public String sayHello() {
        return "Hello Shawn";
    }

    public String sayHello(String name) {
        return "Hello " + name;
    }

    public String sayHello(String firstName, String lastName) {
        return "Hello " + firstName + " " + lastName;
    }

    public String sayHello(int number) {
        return "Hello " + number;
    }

}