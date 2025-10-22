import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int threshold = 50;
        BinaryArray bArray = new BinaryArray(10, threshold);

        Scanner scanner = new Scanner(System.in);
        System.out.print(">>");
        for(int i = 0; i < bArray.length(); i++) {
            int n = scanner.nextInt();
            bArray.add(n);
        }
        bArray.print();
        scanner.close();
    }
}
