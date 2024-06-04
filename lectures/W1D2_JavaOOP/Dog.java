public class Dog {
    // Declaring member variables, NOT initializing
    private String name;
    private int age;
    private String hairColor;

    // Constructor
    public Dog() {
        this.name = "Default Name";
        this.age = 0;
        this.hairColor = "Default Hair Color";
    }

    public Dog(String name) {
        this.name = name;
    }

    public Dog(String name, int age, String hairColor) {
        this.name = name;
        this.age = age;
        this.hairColor = hairColor;

        System.out.println(this.toString());
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getHairColor() {
        return hairColor;
    }

    public void setHairColor(String hairColor) {
        this.hairColor = hairColor;
    }
}