import java.io.*;

public class Main {
    public static void main(String[] args) {
        File file = new File("c:\\Temp\\test2.txt");
        //FileReader fin = null;
        try {
            //fin = new FileReader("c:\\windows\\system.ini");
            FileInputStream fileInputStream = new FileInputStream(file);
            InputStreamReader fin = new InputStreamReader(fileInputStream, "MS949");
            //fin = new FileReader(file);
            int c;
            while ((c = fin.read()) != -1) {
                System.out.print((char) c);
            }
            fin.close();
        } catch (FileNotFoundException e) {
            System.out.println("파일 열기 오류 !!!");
        } catch (IOException e) {
            System.out.println("파일 입출력 오류 !!!");
        }
    }
}
