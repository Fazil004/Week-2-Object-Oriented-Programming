class Animal {
    String name;
    int age;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void makeSound() {
        System.out.println("Generic animal sound");
    }
}

class Dog extends Animal {
    public Dog(String name, int age) {
        super(name, age);
    }

    @Override
    public void makeSound() {
        System.out.println("Woof!");
    }
}

class Cat extends Animal {
    public Cat(String name, int age) {
        super(name, age);
    }

    @Override
    public void makeSound() {
        System.out.println("Meow!");
    }
}

class Bird extends Animal {
    public Bird(String name, int age) {
        super(name, age);
    }

    @Override
    public void makeSound() {
        System.out.println("Chirp!");
    }
}

public class AnimalHierarchy {
    public static void main(String[] args) {
        Animal genericAnimal = new Animal("Unknown", 5);
        Dog myDog = new Dog("Buddy", 3);
        Cat myCat = new Cat("Whiskers", 7);
        Bird myBird = new Bird("Tweety", 2);

        genericAnimal.makeSound();
        myDog.makeSound();
        myCat.makeSound();
        myBird.makeSound();

        Animal[] animals = {myDog, myCat, myBird};
        for (Animal animal : animals) {
            animal.makeSound(); // Polymorphism
        }
    }
}