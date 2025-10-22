public class StringStack implements IStack {
    private String[] stack;
    private int top = - 1;

    public StringStack(int size) {
        stack = new String[size];
    }

    @Override
    public int capacity() {
        return stack.length - top - 1;
    }

    @Override
    public int length() {
        return top + 1;
    }

    @Override
    public boolean push(String val) {
        if (0 >= capacity()) {
            return false;
        }
        stack[++top] = val;
        return true;
    }

    @Override
    public String pop() {
        if (top == -1) return null;
        return stack[top--];
    }
}
