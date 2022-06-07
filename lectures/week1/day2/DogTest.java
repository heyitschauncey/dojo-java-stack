public class DogTest {
    public static void main(String[] args) {
        Dog dog1 = new Dog();
        System.out.printf("Name: %s, Age: %d, Hair Color: %s\n", dog1.getName(), dog1.getAge(), dog1.getHairColor());

        Dog dog2 = new Dog("Sasha", 43, "brindle");
        System.out.printf("Name: %s, Age: %d, Hair Color: %s\n", dog2.getName(), dog2.getAge(), dog2.getHairColor());

        Dog dog3 = new Dog(43, "brindle");
        System.out.printf("Name: %s, Age: %d, Hair Color: %s\n", dog3.getName(), dog3.getAge(), dog3.getHairColor());


        dog1.bark();

        System.out.println(Dog.getNumOfDogs());
    }
}