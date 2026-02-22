public class Dog extends Animal implements Omnivore {
    Dog(String name, int age) {
        super(name,age);
    }

    public String hunt() {
        return "I can hunt for robbers";
    }

    @Override
    public String toString() {
        return String.format("Dog name = %s, age = %d. %s",
                getName(), getAge(), hunt()
                );
    }
}
