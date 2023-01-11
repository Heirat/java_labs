package task8;

public class Main {
    public static void main(String[] args) {
        System.out.println("Linked stack test");
        LinkedStack<Integer> stack = new LinkedStack<>();
        stackTest(stack);

        System.out.println("Array stack test");
        ArrayStack<Integer> arrayStack = new ArrayStack<>(3);
        stackTest(arrayStack);
    }

    private static void stackTest(Stack<Integer> stack) {
        stack.push(50);
        stack.push(40);
        stack.push(30);

        stack.forEach(System.out::println);
        System.out.println("Popped: " + stack.pop());
        System.out.println("Popped: " + stack.pop());
        System.out.println("Popped: " + stack.pop());
        System.out.println("Is stack empty? " + stack.empty());
    }
}
