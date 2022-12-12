package task8;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Spliterator;
import java.util.function.Consumer;

public class LinkedStack<E> implements Stack<E>{
    private Node<E> head = null;

    public LinkedStack() {}

    @Override
    public void push(E element) {
        head = new Node<>(element, head);
    }

    @Override
    public E pop() {
        if (empty())
            throw new NoSuchElementException();
        Node<E> result = head;
        head = head.next;
        result.next = null;
        return result.item;
    }

    @Override
    public E peek() {
        if (empty())
            throw new NoSuchElementException();
        return head.item;
    }

    @Override
    public boolean empty() {
        return head == null;
    }

    @Override
    public void forEach(Consumer<? super E> action) {
        Stack.super.forEach(action);
    }

    @Override
    public Spliterator<E> spliterator() {
        return Stack.super.spliterator();
    }

    @Override
    public Iterator<E> iterator() {
        return new LinkedStackIterator(head);
    }

    private class Node<E> {
        private E item;
        private Node<E> next;


        Node(E element, Node<E> next) {
            this.item = element;
            this.next = next;
        }
    }

    private class LinkedStackIterator implements Iterator<E> {
        Node<E> head;

        @Override
        public boolean hasNext() {
            return head != null;
        }

        @Override
        public E next() {
            if (head == null)
                throw new NoSuchElementException();
            E result = head.item;
            head = head.next;
            return result;
        }

        public LinkedStackIterator(Node<E> head) {
            this.head = head;
        }
    }
}
