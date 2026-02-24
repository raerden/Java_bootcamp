public class Cat extends Animal {
    Cat(String name, int age) {
        super(name,age);
    }

    @Override
    public String toString() {
        return String.format("Cat name = %s, age = %d.",
                getName(), getAge()
        );
    }

    @Override
    public Animal copyWithIncrementedAge() {
        int newAge = getAge() > 10 ? getAge() + 1 : getAge();
        return new Cat(getName(), newAge);
    }
}
