import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {
    public MyFrame() {
        setTitle("GUI 예제");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setBackground(Color.ORANGE);
        c.setLayout(new FlowLayout(FlowLayout.RIGHT, 0, 0)); // 컴포넌트 배치 관리자

        c.add(new JButton("확인"));
        c.add(new JButton("취소"));
        c.add(new JButton("돌아가기"));

        setSize(300, 200);
        setVisible(true);
    }
    public static void main(String[] args) {
        new MyFrame(); // 참조변수에 넣어도 쓸 곳이 없기 때문에, 참조 변수 선언을 안함

    }
}
