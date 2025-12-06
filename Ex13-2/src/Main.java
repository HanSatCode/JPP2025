public class Main {
    public static void main(String[] args) {
        SharedBoard board = new SharedBoard();
        Thread th1 = new StudentThread("홍길동", board);
        Thread th2 = new StudentThread("김하늘", board);
        Thread th3 = new StudentThread("박하하", board);

        th1.start();
        th2.start();
        th3.start();
    }
}
