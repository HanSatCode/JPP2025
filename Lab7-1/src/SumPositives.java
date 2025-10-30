import java.util.Vector;
import java.util.Scanner;

public class SumPositives {
    private Vector<Integer> v = new Vector<>();  // 멤버 변수

    public void read() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("0이 입력될 때까지 정수 입력 >> ");
        while(true) {
            int n = scanner.nextInt();
            if (n == 0) break;
            v.add(n);
        }
        scanner.close();
    }

    public void changeToZero() {
        for(int i = 0; i < v.size(); i++) {
            if(v.get(i) < 0) v.set(i, 0);
        }
    }

    public void showAll() {
        for(int element : v) System.out.print(element  + " ");
        System.out.println();
    }

    public int add() {
        int sum = 0;
        for(int element : v) sum += element;
        return sum;
    }
}
