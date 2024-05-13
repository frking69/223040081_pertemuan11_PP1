// Abstrak Stack yang menjadi dasar untuk stack-stack lainnya
abstract class AbstractStack {
    protected int capacity;

    public AbstractStack(int capacity) {
        this.capacity = capacity;
    }

    public abstract void push(int element);
    public abstract int pop();
    public abstract int peek();
    public abstract void displayStack();
}
