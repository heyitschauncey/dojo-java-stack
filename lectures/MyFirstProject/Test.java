public class Test {
  public static void main(String[] args) {
    System.out.println("Hello there.");
    System.out.println("General Kenobi");

    int currentTemp = 59;
    String currentCity = "San Jose";

    System.out.println(currentTemp);
    System.out.println(currentCity);

    if (currentTemp < 60) {
      System.out.println("Its a bit chilly outside.");
    } else if (currentTemp < 70) {
      System.out.println("Its warming up.");
    } else {
      System.out.println("Its a bit warm outside.");
    }

    String s1 = new String("String");
    String s2 = new String("String");

    if (s1.equals(s2)) {
      System.out.println("The strings are equal");
    } else {
      System.out.println("The strings not are equal");
    }

    Greetings greetings = new Greetings();

    greetings.greeting();
    greetings.greeting("Mann");
  }
}
