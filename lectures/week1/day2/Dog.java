public class Dog {
    private String name;
    private int age;
    private String hairColor;
    private static int numOfDogs = 0;

    public Dog() {
        this.name = "Pepper";
        this.age = 42;
        this.hairColor = "gray";
        addDog();
    }

    public Dog(int age, String hairColor) {
        this.name = "Vicky";
        this.age = age;
        this.hairColor = hairColor;
        addDog();
    }

    // public Dog(String name, String d) {
    //     if (d.equals("name")) {

    //     }
    //     this.name = "Vicky";
    //     this.age = age;
    //     this.hairColor = hairColor;
    // }
    // public Dog(String hairColor) {
    //     this.name = "Vicky";
    //     this.age = age;
    //     this.hairColor = hairColor;
    // }

    public Dog(String name, int age, String hairColor) {
        this.name = name;
        this.age = age;
        this.hairColor = hairColor;   
        addDog();
    }

    private static void addDog() {
        numOfDogs++;
    }

    public static int getNumOfDogs() {
        return numOfDogs;
    }

    public void bark() {
        System.out.println("Borf Borf");
    }

    public String getName() {
        return name;
    }

    public void setName(String newName) {
        name = newName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int newAge) {
        if (newAge > age) {
            age = newAge;
        }
    }

    public String getHairColor() {
        return hairColor;
    }

    public void setHairColor(String newHairColor) {
        hairColor = newHairColor;
    }
}