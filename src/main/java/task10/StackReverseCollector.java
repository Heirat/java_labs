package task10;

import task8.ArrayStack;
import task8.Stack;

import java.util.HashSet;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class StackReverseCollector<T> implements Collector<T, Stack<T>, Stack<T>> {
    public StackReverseCollector() {
    }

    @Override
    public Supplier<Stack<T>> supplier() {
        return ArrayStack::new;
    }

    @Override
    public BiConsumer<Stack<T>, T> accumulator() {
        return Stack::push;
    }

    @Override
    public BinaryOperator<Stack<T>> combiner() {
        return (stack1, stack2) -> {
            stack2.forEach(stack1::push);
            return stack1;
        };
    }

    @Override
    public Function<Stack<T>, Stack<T>> finisher() {
        return null;
    }

    @Override
    public Set<Characteristics> characteristics() {
        Set<Characteristics> result = new HashSet<>();
        result.add(Characteristics.IDENTITY_FINISH);
        return result;
    }
}
