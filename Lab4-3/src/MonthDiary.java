import java.util.Scanner;

public class MonthDiary {
    private Scanner scanner = new Scanner(System.in);
    private DayDiary[] myDiary = new DayDiary[30];
    int year; int month;

    public MonthDiary(int year, int month) {
        this.year = year; this.month = month;
    }

    public void write() {
        System.out.print("날짜(1~30)와 텍스트(빈칸없이 4글자이하) >> ");
        int date = scanner.nextInt(); String text = scanner.next();
        myDiary[date - 1] = new DayDiary(text);
    }

    public void show() {
        for(int i = 0; i < 30; i++) {
            if (myDiary[i] != null)  System.out.print(myDiary[i].getText() + "\t");
            else System.out.print("...\t\t\t");
            if ((i+1) % 7 == 0) System.out.println();
        }
        System.out.println();
    }

    public void getMenu() {
        System.out.print("기록:1, 보기:2, 종료:3 >> ");
    }


    public void run() {
        int select = 0;
        System.out.println("***** 2025년 10월 다이어리 *****");
        while(select != 3) {
            getMenu(); select = scanner.nextInt();
            switch (select) {
                case 1 -> write();
                case 2 -> show();
                case 3 -> {
                    System.out.println("프로그램을 종료합니다.");
                }
                default -> {
                    System.out.println("[경고] 잘못 선택하였습니다. 다시 선택해주세요.");
                }
            }
        }
    }
}
