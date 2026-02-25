import java.util.List;

interface BaseIterator<T> {
    T next();
    boolean hasNext();
    void reset();
}

public class AnimalIterator implements BaseIterator<Animal> {
    List<Animal> petList;
    private int index = 0;

    public AnimalIterator(List<Animal> pets) {
        this.petList = pets;
    }

    @Override
    public Animal next() {
        if (hasNext()) {
           return petList.get(index++);
        }
        return null;
    }

    @Override
    public boolean hasNext() {
        return index < petList.size();
    }

    @Override
    public void reset() {
        index = 0;
    }
}
