public class Person {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }


    public Person(Person otherPerson) {
        this.name = otherPerson.name;
        this.age = otherPerson.age;
    }

    public void displayPersonInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }

    public static void main(String[] args) {
        Person person1 = new Person("Alice", 30);
        System.out.println("Person 1:");
        person1.displayPersonInfo();

        Person person2 = new Person(person1); // Using the copy constructor
        System.out.println("\nPerson 2 (Copy of Person 1):");
        person2.displayPersonInfo();

        person2.name = "Bob";
        person2.age = 35;
        System.out.println("\nPerson 2 (After modification):");
        person2.displayPersonInfo();
        System.out.println("\nPerson 1 (Unchanged):");
        person1.displayPersonInfo();
    }
}