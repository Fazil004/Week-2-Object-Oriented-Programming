class Person {
    String name;
    int id;

    public Person(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public void displayPersonalInfo() {
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
    }
}

interface Worker {
    void performDuties();
}

class Chef extends Person implements Worker {
    String specialization;

    public Chef(String name, int id, String specialization) {
        super(name, id);
        this.specialization = specialization;
    }

    @Override
    public void performDuties() {
        System.out.println(name + " (Chef) is cooking delicious meals.");
    }

    public void displayChefInfo() {
        displayPersonalInfo();
        performDuties();
        System.out.println("Specialization: " + specialization);
    }

    public static void main(String[] args) {
        Chef chef = new Chef("Gordon", 101, "Italian");
        chef.displayChefInfo();
    }
}

class Waiter extends Person implements Worker {
    int servedTables;

    public Waiter(String name, int id, int servedTables) {
        super(name, id);
        this.servedTables = servedTables;
    }

    @Override
    public void performDuties() {
        System.out.println(name + " (Waiter) is taking orders and serving customers.");
    }

    public void displayWaiterInfo() {
        displayPersonalInfo();
        performDuties();
        System.out.println("Served Tables: " + servedTables);
    }

    public static void main(String[] args) {
        Waiter waiter = new Waiter("Alice", 202, 5);
        waiter.displayWaiterInfo();
    }
}