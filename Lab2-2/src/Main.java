import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("연산 입력>>");
        double operand1 = scanner.nextDouble();
        String operator = scanner.next();
        double operand2 = scanner.nextDouble();
        double result = (double)0.0F;
        switch (operator) {
            case "더하기":
                result = operand1 + operand2;
                break;
            case "빼기":
                result = operand1 - operand2;
                break;
            case "곱하기":
                result = operand1 * operand2;
                break;
            case "나누기":
                if (operand2 == (double)0.0F) {
                    System.out.println("0으로 나눌 수 없습니다.");
                    return;
                }

                result = operand1 / operand2;
                break;
            default:
                System.out.println("사칙연산이 아닙니다.");
                return;
        }

        System.out.println(operand1 + " " + operator + " " + operand2 + "의 계산 결과는 " + result);
    }
}
