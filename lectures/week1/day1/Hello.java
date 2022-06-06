public class Hello {
    public static void main(String[] args) {
        String message = "Coding Dojo is Awesome!";

        System.out.println(message);

        boolean isRaining = false;
        boolean isCold = true;
            
        if(isRaining) {
            System.out.println("Bring an umbrella.");
        }
        else if(isCold) {
            System.out.println("Wear a coat.");
        }
        else {
            System.out.println("Have fun!");
        }

        String ninja = new String("Coding Dojo is Awesome!");
        int length = ninja.length();
        System.out.println( "String Length is : " + length );

        System.out.println(message.equals(ninja));

        Greeting greeting = new Greeting();

        greeting.greeting();
    }

    public String hello() {
        System.out.println("Hello there!");

        return "Hello!";
        // return 5;
    }
}