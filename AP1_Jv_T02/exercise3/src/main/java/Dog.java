public class Dog extends Animal {
    Dog(String name, int age) {
        super(name,age);
    }

    @Override
    public String toString() {
        return String.format("Dog name = %s, age = %d.",
                getName(), getAge()
        );
    }

    @Override
    public Animal copyWithIncrementedAge() {
        int newAge = getAge() > 10 ? getAge() + 1 : getAge();
        return new Dog(getName(), newAge);
    }
}
