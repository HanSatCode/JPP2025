//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while(true) {
            System.out.print("곱하고자 하는 정수 2개 입력>>");

            try {
                int n = scanner.nextInt();
                int m = scanner.nextInt();
                System.out.println(n + "x" + m + "=" + n * m);
                break;
            } catch (InputMismatchException var5) {
                System.out.println("정수를 입력하세요!");
                scanner.nextLine();
            }
        }

        scanner.close();
    }
}
