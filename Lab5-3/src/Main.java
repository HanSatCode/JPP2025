import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("스택 용량 >> ");
        int size = scanner.nextInt();
        StringStack myStack = new StringStack(size);
        scanner.nextLine();

        while(true){
            System.out.print("문자열 입력 >> ");
            String select = scanner.nextLine();

            if (select.equals("그만")) break;

            if (!myStack.push(select)) {
                System.out.println("스택이 꽉 차서 " + select +" 저장 불가");
            };
        }

        int length = myStack.length();

        System.out.print("스택에 저장된 문자열 팝 : ");
        for(int i = 0; i < length; i++) {
            System.out.print(myStack.pop() + " ");
        }
    }
}
