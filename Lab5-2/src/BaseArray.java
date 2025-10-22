public class BaseArray {
    protected int[] array;
    protected int nextIndex = 0;
    public BaseArray(int size) {
        array = new int[size];
    }
    public int length() { return array.length;}
    public void add(int n) {
        if(nextIndex == array.length) return;
        array[nextIndex] = n;
        nextIndex++;
    }
    public void print() {
        for(int n : array) System.out.print(n + " ");
        System.out.println();
    }
}
