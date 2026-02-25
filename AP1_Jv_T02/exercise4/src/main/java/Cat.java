import java.util.concurrent.TimeUnit;

public class Cat extends Animal {
    Cat(String name, int age) {
        super(name,age);
    }

    @Override
    public String toString() {
        return String.format("Cat name = %s, age = %d",
                getName(), getAge()
        );
    }

    @Override
    public double goToWalk() {
        double walkTime = getAge() * 0.25;

        try {// метод "заснет" на walkTime секунд: 4 * 0.25 = 1
            TimeUnit.SECONDS.sleep((long) walkTime);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        return walkTime;
    }
}
