import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {
    private Thread th;

    public MyFrame() {
        super("타이머 예제");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(new FlowLayout());

        JLabel timerLabel = new JLabel();
        timerLabel.setFont(new Font("Gothic", Font.BOLD, 80));
        c.add(timerLabel);
        th = new Thread(new TimerRunnable(timerLabel));
        th.start();
        JButton btn = new JButton("Kill");
        btn.addActionListener(e -> {
            th.interrupt();
            btn.setEnabled(false);
        });
        c.add(btn);

        setSize(300, 200);
        setVisible(true);
    }

    public static void main(String[] args) {
        new MyFrame();
    }
}
