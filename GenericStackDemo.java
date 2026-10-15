
import java.util.NoSuchElementException;

class GenericStack<T> {

    private Object[] elements;
    private int top;

    public GenericStack(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException(
                    "Capacity must be positive");
        }

        elements = new Object[capacity];
        top = -1;
    }

    public void push(T value) {
        if (top == elements.length - 1) {
            throw new IllegalStateException("Stack is full");
        }

        elements[++top] = value;
    }

    @SuppressWarnings("unchecked")
    public T pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }

        T value = (T) elements[top];
        elements[top] = null;
        top--;

        return value;
    }

    @SuppressWarnings("unchecked")
    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }

        return (T) elements[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public int size() {
        return top + 1;
    }
}

public class GenericStackDemo {

    public static void main(String[] args) {

        GenericStack<Integer> numbers = new GenericStack<>(5);

        numbers.push(10);
        numbers.push(20);
        numbers.push(30);

        System.out.println("Integer Stack Top: " + numbers.peek());
        System.out.println("Popped Integer: " + numbers.pop());
        System.out.println("Stack Size: " + numbers.size());

        GenericStack<String> names = new GenericStack<>(5);

        names.push("Amit");
        names.push("Rahul");

        System.out.println("String Stack Top: " + names.peek());
        System.out.println("Popped Name: " + names.pop());

        GenericStack<Integer> emptyStack = new GenericStack<>(3);

        System.out.println("Is Empty: " + emptyStack.isEmpty());

        try {
            emptyStack.pop();
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("25CE057");
    }
}
