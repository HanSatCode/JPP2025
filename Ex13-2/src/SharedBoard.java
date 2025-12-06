public class SharedBoard {
    private int sum = 0;

    public void add() {
        int n = sum;
        Thread.yield(); // 충돌상황 만들기
        n += 10;
        sum = n;
        System.out.println(Thread.currentThread().getName() + " : " + sum);
    }

    public int getSum() {
        return sum;
    }
}
