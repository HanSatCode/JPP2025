import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static int getPrice(String[] menu, int[] price, String select, int value) {
        for(int i = 0; i < menu.length; i++) {
            if(select.equals(menu[i])) return price[i] * value;
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] coffee = {"핫아메리카노", "아이스아메리카노", "카푸치노", "라떼"};
        int[] price = { 3000, 3500, 4000, 5000 };
        for(int i = 0; i < coffee.length; i++) {
            if (i < coffee.length - 1) System.out.print(coffee[i] + ",  ");
            else System.out.println(coffee[i] + " 있습니다.");
        }
        while(true) {
            System.out.print("주문 >> ");
            try {
                String select = scanner.next();
                if (select.equals("그만")) break;
                int value = scanner.nextInt();
                int result = getPrice(coffee, price, select, value);
                System.out.println(result != -1 ? "가격은 " + result + "원입니다." : select +"(은)는 없는 메뉴입니다.");
            } catch (InputMismatchException e) {
                System.out.println("잔 수는 양의 정수로 입력해주세요!");
                scanner.nextLine(); // 버퍼 비우기
            }
        }
    }
}