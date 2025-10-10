//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        byte POWER = 1;
        byte DOOR = 2;
        byte LAMP = 4;
        byte TEMP = 8;
        System.out.print("냉장고 상태 입력>>");
        String inputStatus = scanner.next();
        byte status = Byte.parseByte(inputStatus, 2);
        if ((status & 1) != 0) {
            System.out.print("전원 켜져 있음. ");
        } else {
            System.out.print("전원 꺼져 있음. ");
        }

        if ((status & 2) != 0) {
            System.out.print("문 닫혀 있음. ");
        } else {
            System.out.print("문 열려 있음. ");
        }

        if ((status & 4) != 0) {
            System.out.print("전구 정상 작동. ");
        } else {
            System.out.print("전구 손상 상태. ");
        }

        if ((status & 8) != 0) {
            System.out.println("냉장고 온도 3도 미만.");
        } else {
            System.out.println("냉장고 온도 3도 이상.");
        }

    }
}
