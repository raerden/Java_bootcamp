abstract class Animal {
    private String name;
    private int age;
    private double weigth;

    Animal(String name, int age, double weigth) {
        this.name = name;
        this.age = age;
        this.weigth = weigth;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getWeigth() { return weigth; }

    public abstract String toString();

    public abstract double getFeedInfoKg();
}

// Класс для собачек
class Dog extends Animal {
    public Dog(String name, int age, double weigth) {
        super(name, age, weigth);
    }

    @Override
    public String toString() {
        return String.format("Dog name = %s, age = %d, mass = %.2f, feed = %.2f",
                getName(), getAge(), getWeigth(), getFeedInfoKg());
    }

    @Override
    public double getFeedInfoKg() {
        return super.getWeigth() * 0.3;
    }
}

// Класс для кошечек
class Cat extends Animal {
    public Cat(String name, int age, double weigth) {
        super(name, age, weigth);
    }

    @Override
    public String toString() {
        return String.format("Cat name = %s, age = %d, mass = %.2f, feed = %.2f",
                getName(), getAge(), getWeigth(), getFeedInfoKg());
    }

    @Override
    public double getFeedInfoKg() {
        return super.getWeigth() * 0.1;
    }
}