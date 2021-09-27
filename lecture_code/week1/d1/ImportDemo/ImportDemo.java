import java.util.Date;
public class ImportDemo {
    public String getCurrentDate() {
        Date date = new Date();
        return "Current date is: " + date;
    }

    public String guestGreeting(String name, String dayPeriod) {
        return "Hello " + name + "! Good " + dayPeriod + "!";
    }

    public String guestGreeting(int thing1, String thing2) {
        return "thing";
    }

    
}