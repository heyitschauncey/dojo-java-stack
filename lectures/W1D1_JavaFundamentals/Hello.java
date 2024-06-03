public class Hello{
    public static void main(String[] args) {
        String firstName = "Shawn";
        int age = 30;
        boolean wearingRedShirt = true;

        System.out.println(firstName);
        System.out.println(age);
        System.out.println(wearingRedShirt);

        char myChar = 'A';

        String anotherString = "l";

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

        // String str = 5 < 10 ? "smaller" : "larger";

        System.out.println("string1".equals("string2"));
        // String a = new String("same letters");
        // String b = new String("same letters");
        // System.out.println(a == b); // false. Not the same object in memory.
        // System.out.println(a.equals(b)); // true. same exact characters.
    }
}