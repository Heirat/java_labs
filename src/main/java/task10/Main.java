package task10;

import task8.Stack;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        // Реверсия стека
        Stack<Integer> stack = Stream.of(1, 2, 3, 4, 5).collect(new StackReverseCollector<>());
        stack.forEach(System.out::println);
        // Реверсия потока в произвольную коллекцию (ArrayList)
        Collection<String> collection = Stream.of("A", "B", "C", "D").collect(new ReverseCollector<>(ArrayList::new));
        collection.forEach(System.out::println);
    }
}
