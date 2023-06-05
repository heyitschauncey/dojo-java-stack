import java.util.ArrayList;
import java.util.HashMap;

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

        int intNum = 51629545;
        short shortNum = (short)intNum;

        System.out.println("Int Num: " + intNum);
        System.out.println("Short Num: " + shortNum);

        long newLong = 2147483648L;
        int newInt = (int)newLong;
        System.out.println("Long Num: " + newLong);
        System.out.println("Int Num: " + newInt);

        // Integer a = null;
        // int b = null;

        // Arrays
        // int[] myArr;
        // myArr = new int[5];
        // int[] myArr = new int[5];
        // myArr[0] = 6;
        // myArr[1] = 7;
        // myArr[2] = 8;
        // myArr[3] = 10;
        // myArr[4] = 8;

        int[] myArr = {6, 7, 8, 10, 8};
        System.out.println(myArr);

        ArrayList<Integer> myArray = new ArrayList<Integer>();

        ArrayList<Float> listOfFloats = new ArrayList<Float>();

        ArrayList<Double> listOfDoubles = new ArrayList<Double>();

        // two data types are for the Key and the value respectively
        HashMap<String, String> myMap = new HashMap<String, String>();
    }
}
