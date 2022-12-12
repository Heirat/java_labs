package task8;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * Стек, основанный на статическом массиве.
 *
 * @param <E>
 */
public class ArrayStack<E> implements Stack<E>{
    private Object[] array;
    private int maxSize;
    private int curSize = 0;

    public ArrayStack() {
        this(10);
    }

    public ArrayStack(int size) {
        this.array = new Object[size];
        maxSize = size;
    }

    @Override
    public void push(E element) {
        if (curSize == maxSize) {
            maxSize *= 1.5;
            System.out.println(maxSize);
            array = Arrays.copyOf(array, maxSize);
        }

        array[++curSize] = element;
    }

    @Override
    public E pop() {
        if (empty())
            throw new NoSuchElementException();
        return (E) array[curSize--];
    }

    @Override
    public E peek() {
        if (empty())
            throw new NoSuchElementException();
        return (E) array[curSize];
    }

    @Override
    public boolean empty() {
        return curSize == 0;
    }

    @Override
    public Iterator<E> iterator() {
        return new ArrayStackIterator(this);
    }

    @Override
    public void forEach(Consumer<? super E> action) {
        Stack.super.forEach(action);
    }

    @Override
    public Spliterator<E> spliterator() {
        return Stack.super.spliterator();
    }

    private class ArrayStackIterator implements Iterator<E> {
        private final Object[] array;
        private int curSize;

        public ArrayStackIterator(ArrayStack<E> arrayStack) {
            this.array = arrayStack.array;
            this.curSize = arrayStack.curSize;
        }

        @Override
        public boolean hasNext() {
            return curSize > 0;
        }

        @Override
        public E next() {
            if (curSize == 0)
                throw new NoSuchElementException();
            return (E) array[curSize--];
        }
    }
}
