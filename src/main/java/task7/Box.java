package task7;

import java.util.NoSuchElementException;

public class Box<E> {
    private final E[] array;
    private final int maxSize;
    private int size;
    public int getSize() {
        return size;
    }

    public Box(int length) {
        array = (E[]) new Object[length];
        maxSize = length;
        size = 0;
    }

    public void put(E newElem) {
        if (size == maxSize)
            throw new IndexOutOfBoundsException("Коробка заполнена.");
        array[size] = newElem;
        size += 1;
    }

    public E get()  {
        if (size == 0)
            throw new IndexOutOfBoundsException("Коробка пуста.");
        int randomIndex = (int) (Math.random() * (size));
        return array[randomIndex];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean remove(E elem) {
        if (size == 0)
            throw new NoSuchElementException("Коробка пуста");
        for (int i = 0; i < size; i++) {
            if (array[i].equals(elem)) {
                for (int j = i; j < size - 1; j++) {
                    array[j] = array[j+1];
                }
                size--;
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("Box ");
        for (int i = 0; i < size; i++) {
            result.append(array[i].toString()).append(" ");
        }
        return result.toString();
    }
}
