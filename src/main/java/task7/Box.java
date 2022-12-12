package task7;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class Box<E> {
    private final List<E> array;
    private final int maxSize;

    public Box(int length) {
        array = new ArrayList<>(length);
        maxSize = length;
    }

    public void put(E newElem) {
        if (size() == maxSize)
            throw new IndexOutOfBoundsException("Коробка заполнена.");
        array.add(newElem);
    }

    public E get()  {
        if (size() == 0)
            throw new IndexOutOfBoundsException("Коробка пуста.");
        int randomIndex = (int) (Math.random() * (size() - 1));
        return array.get(randomIndex);
    }

    public boolean isEmpty() {
        return array.isEmpty();
    }

    public int size() {
        return array.size();
    }

    public boolean remove(E elem) {
        if (size() == 0)
            throw new NoSuchElementException("Коробка пуста");

        return array.remove(elem);
    }

    @Override
    public String toString() {
        return "Box{" +
                "array=" + array +
                '}';
    }
}
