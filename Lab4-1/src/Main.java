import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("이름, 자바, 웹프로그래밍, 운영체제 순으로 점수 입력 >> ");
        String name = scanner.next();
        int java = scanner.nextInt();
        int web = scanner.nextInt();
        int os = scanner.nextInt();

        Grade st = new Grade(name, java, web, os);
        System.out.println(st.getName() + "의 평균은 " + st.getAverage());
        scanner.close();

    }
}
