public class BinaryArray extends BaseArray {
    private int threshold;
    public BinaryArray(int size, int threshold) {
        super(size);
        this.threshold = threshold;
    }

    @Override
    public void print() {
        for(int n : array) System.out.print((n > threshold ? 1 : 0) + " ");
        System.out.println();
    }
}
