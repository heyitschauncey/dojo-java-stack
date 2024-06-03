import java.util.ArrayList;
import java.util.HashMap;

public class TestGreetings {
    
    public static void main(String[] args) {
        
        // To use the greetings methods
        // create a variable of type Greetings
    
        Greetings greeterApp = new Greetings();
 
        // Use the variable to access Greetings methods
        // using dot notation.
    
        String dateMessage = greeterApp.getCurrentDate();
        System.out.println(dateMessage);

        int i = 70000;
        // short s = (short) i;
        String s = Integer.toString(i);

        System.out.println(s);


        String[] names;
        names = new String[5];


        String[] moreNames = {"Joe", "David", "John"};

        moreNames[0] = null;

        ArrayList<String> listNames = new ArrayList<String>();

        listNames.add("Heidi");
        listNames.get(0);

        for (String name : listNames) {
            System.out.println(name);
        }


        HashMap<String, String> dogsAndOwners = new HashMap<String, String>();
    }
}