package task8;


public interface Stack<E> extends Iterable<E>{

    /**
     * Поместить элемент в стэк.
     *
     * @param element элемент
     */
    void push(E element);

    /**
     * Вытолкнуть элемент из стэка.
     *
     * @return вытолкнутый элемент
     */
    E pop();

    /**
     * Получить значение верхушки стэка.
     *
     * @return элемент верхушки стэка
     */
    E peek();

    /**
     * Проверить является ли стэк пустым.
     *
     * @return {@code true} - пустой, {@code false} - содержит элементы
     */
    boolean empty();

}

