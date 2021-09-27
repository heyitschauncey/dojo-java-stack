import java.util.ArrayList;
import java.util.HashMap;

public class JavaFoundations {
    public static void main(String[] args) {
        String[] words = {"banaba", "hot dog", "pizaa", "Korean"};

        // System.out.println(words);
        System.out.println(String.join("hotogt", words));
        
        int test = 42;

        ArrayList<Integer> list = new ArrayList<Integer>();

        list.add(test);
        System.out.println(list.get(0).getClass());
        

        HashMap<String, String> userMap = new HashMap<String, String>();

        userMap.put("name", "Sadie");
        userMap.put("character", "bard rock gnome");

        System.out.println(userMap.get("name"));
        // in python
        // myDict = {
        //     "name": "Sadie",
        //     "character": "bard rock gnome"
        // }
    }
}

// NAMING CONVENTIONS
// classes are Pascal Case (UpperCamelCase)
// files are the SAME NAME as the class .java