import java.util.ArrayList;

public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello There");

        // camelCaseStyling
        String bestResponse = "General Kenobi";
        System.out.println(bestResponse);

        Greeting newGreeting = new Greeting();
        System.out.println(newGreeting.sayHello());
        System.out.println(newGreeting.sayHello("Trong"));
        System.out.println(newGreeting.sayHello("Lesley", "Yang"));
        System.out.println(newGreeting.sayHello(42));

        int[] nums = {4, 5, 3, 3, 5, 7};
        System.out.println(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            System.out.printf("%d, ", nums[i]);
        }
        System.out.printf("%d\n", nums[nums.length - 1]);

        ArrayList<String> names = new ArrayList<String>();
        ArrayList<String> moreNames = new ArrayList<String>();

        names.add("Vicky");
        names.add("Leia");
        names.add("Shiro");
        System.out.println(names);

        moreNames.add("Bosco");
        moreNames.add("Spot");
        moreNames.add("Fido");
        System.out.println(moreNames);

        moreNames.addAll(names);
        System.out.println(moreNames);

    }

}