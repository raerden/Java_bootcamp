import java.util.concurrent.TimeUnit;

public class Dog extends Animal {
    Dog(String name, int age) {
        super(name,age);
    }

    @Override
    public String toString() {
        return String.format("Dog name = %s, age = %d",
                getName(), getAge()
        );
    }

    @Override
    public double goToWalk() {
        double walkTime = getAge() * 0.5;

        try {// метод "заснет" на walkTime секунд: 4 * 0.5 = 2
            TimeUnit.SECONDS.sleep((long) walkTime);
            // TimeUnit.MILLISECONDS.sleep() - в задании вывод с долями секунд
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        return walkTime;
    }
}
