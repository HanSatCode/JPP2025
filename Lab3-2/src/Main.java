//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.util.Scanner;

public class Main {
    public static void fillArray(int[][] n) {
        for(int i = 0; i < n.length; ++i) {
            for(int j = 0; j < n[i].length; ++j) {
                n[i][j] = (int)(Math.random() * (double)256.0F);
            }
        }

    }

    public static void printArray(int[][] n) {
        for(int i = 0; i < n.length; ++i) {
            for(int j = 0; j < n[i].length; ++j) {
                System.out.print(n[i][j] + "\t");
            }

            System.out.println();
        }

    }

    public static void changeArray(int[][] n, int threshold) {
        for(int i = 0; i < n.length; ++i) {
            for(int j = 0; j < n[i].length; ++j) {
                n[i][j] = n[i][j] > threshold ? 255 : 0;
            }
        }

    }

    public static void main(String[] args) {
        int[][] myArray = new int[4][4];
        Scanner scanner = new Scanner(System.in);
        System.out.println("4x4 배열에 랜덤한 값을 저장한 후 출력합니다.");
        fillArray(myArray);
        printArray(myArray);
        System.out.print("임계값 입력>>");
        int threshold = scanner.nextInt();
        changeArray(myArray, threshold);
        printArray(myArray);
    }
}
