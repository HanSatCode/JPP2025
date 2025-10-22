import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("문자열을 입력하세요. 빈 칸이 있어도 되고 영어 한글 모두 됩니다.");
        String str = scanner.nextLine();
        for(int i = 0; i < str.length(); i++){
            str = str.substring(1) + str.charAt(0);
            System.out.println(str);
        }
    }
}
