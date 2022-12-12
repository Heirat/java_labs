package task10;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class ReverseCollector<T> implements Collector<T, Stack<T>, Collection<T>> {
    Supplier<Collection<T>> collectionBuilder;

    public ReverseCollector(Supplier<Collection<T>> builder) {
        collectionBuilder = builder;
    }

    @Override
    public Supplier<Stack<T>> supplier() {
        return Stack::new;
    }

    @Override
    public BiConsumer<Stack<T>, T> accumulator() {
        return Stack::push;
    }

    @Override
    public BinaryOperator<Stack<T>> combiner() {
        return (col1, col2) -> {
            col2.forEach(col1::push);
            return col1;
        };
    }

    @Override
    public Function<Stack<T>, Collection<T>> finisher() {
        Collection<T> collection = collectionBuilder.get();
        return stack -> {
            while (!stack.empty()) {
                collection.add(stack.pop());
            }
            return collection;
        };
    }

    @Override
    public Set<Characteristics> characteristics() {
        return new HashSet<>();
    }
}
