public class MyStack extends AbstractStack {
    private int[] arr;  // Array untuk menyimpan elemen-elemen dalam stack
    private int top;    // Indeks elemen teratas dalam stack

    public MyStack(int capacity) {
        super(capacity);
        arr = new int[capacity];
        top = -1;  // Pada awalnya stack kosong
    }

    @Override
    public void push(int element) {
        if (top == capacity - 1) {
            throw new StackOverflowException("Stack penuh!");
        }
        top++;
        arr[top] = element;
    }

    @Override
    public int pop() {
        if (top == -1) {
            throw new EmptyStackException("Stack kosong!");
        }
        int element = arr[top];
        top--;
        return element;
    }

    @Override
    public int peek() {
        if (top == -1) {
            throw new EmptyStackException("Stack kosong!");
        }
        return arr[top];
    }

    @Override
    public void displayStack() {
        System.out.println("Stack (bawah --> atas):");
        for (int i = 0; i <= top; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        MyStack stack = new MyStack(5);

        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Elemen teratas: " + stack.peek());

        stack.pop();
        stack.pop();

        stack.displayStack();
    }
}

class StackOverflowException extends RuntimeException {
    public StackOverflowException(String message) {
        super(message);
    }
}

class EmptyStackException extends RuntimeException {
    public EmptyStackException(String message) {
        super(message);
    }
}
