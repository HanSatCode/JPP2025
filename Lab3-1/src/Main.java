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
            System.out.print("정수를 입력하시오>>");

            int n;
            try {
                n = scanner.nextInt();
            } catch (InputMismatchException var5) {
                System.out.println("숫자가 아닙니다.");
                String temp = scanner.nextLine();
                continue;
            }

            if (n > 0) {
                for(int i = 0; i < n; ++i) {
                    for(int j = 0; j < n - i; ++j) {
                        System.out.print("*");
                    }

                    System.out.println();
                }

                return;
            }
        }
    }
}
