import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] word = {"happy", "morning", "package", "together"};
        while(true){
            System.out.println("10초 안에 단어를 맞추세요!!");

            int randNum = (int)(Math.random() * 4);
            char[] select = word[randNum].toCharArray();
            for(int i = 0; i < select.length; i++){
                int rand =  (int) (Math.random() * select.length);
                char temp =  select[i];
                select[i] = select[rand];
                select[rand] = temp;
            }
            System.out.println(select);

            long start = System.currentTimeMillis();
            System.out.print(">> "); String answer = scanner.nextLine();
            if (answer.equals("그만")) break;
            long end = System.currentTimeMillis();

            if(answer.equals(word[randNum])) {
                System.out.println("성공!!! " + (end - start) / 1000 + "초 경과");
            } else {
                if ((end - start) / 1000 > 10) // 10초를 넘어서면
                    System.out.println("실패!!! 10초 초과. " + (end - start) / 1000+ "초 경과");
                else
                    System.out.println("실패!!! " + (end - start) / 1000 + "초 경과");
            }
        }
    }
}
