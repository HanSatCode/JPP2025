import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        HashMap<String, Integer> customer = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("** 마일리지 관리 프로그램입니다. **");
        while(true) {
            System.out.print("이름과 마일리지 >> ");
            String name = scanner.next();
            if (name.equals("그만")) break;
            int mileage = scanner.nextInt();
            Integer value = customer.get(name); // int로 안하는 이유 : key가 없다면 null을 리턴하기 때문
            if(value != null) customer.put(name, value + mileage);
            else customer.put(name, mileage);
        }

        int bestMile = -1; String bestUser = null;
        for(String name : customer.keySet()) {
            int point = customer.get(name);
            System.out.print("(" + name + ":" + point + ")");
            if (point > bestMile) {
                bestUser = name;
                bestMile = point;
            }
        }
        System.out.println("\n가장 마일리지가 높은 고객은 " + bestUser + "입니다.");
        System.out.println("프로그램을 종료합니다.");
    }
}
