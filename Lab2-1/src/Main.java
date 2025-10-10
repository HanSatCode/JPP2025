import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("여행지>>");
        String place = scanner.nextLine();
        System.out.print("인원수>>");
        int numOfPerson = scanner.nextInt();
        System.out.print("숙박일>>");
        int numOfDays = scanner.nextInt();
        System.out.print("1인당 항공료>>");
        int fareOfAirplane = scanner.nextInt();
        System.out.print("1명 숙박비>>");
        int feeOfRoom = scanner.nextInt();
        int numOfRooms = numOfPerson / 2 + numOfPerson % 2;
        int totalCost = feeOfRoom * numOfRooms * numOfDays + fareOfAirplane * numOfPerson;
        System.out.print(numOfPerson + "명의 " + place + " " + numOfDays + "박 " + (numOfDays + 1) + "일 여행에는 ");
        System.out.println("방이 " + numOfRooms + "개 필요하며 경비는 " + totalCost + "원 입니다.");
    }
}