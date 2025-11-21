import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MyFrame extends JFrame {
    public MyFrame() {
        super("키 이벤트 예제");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container c =  getContentPane();
        c.setLayout(new BorderLayout());
        JLabel textLabel = new JLabel("Love Java");
        c.add(textLabel);
        textLabel.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    JLabel la = (JLabel) e.getSource();
                    String text = la.getText();
                    la.setText(text.substring(1) + text.substring(0, 1));
                }
                else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    JLabel la = (JLabel) e.getSource();
                    String text = la.getText();
                    la.setText(text.substring(text.length() - 1) + text.substring(0, text.length() - 1));
                }
            }
        });
        setSize(300, 200);
        setVisible(true);

        textLabel.setFocusable(true);
        textLabel.requestFocus();
    }

    public static void main(String[] args) {
        new MyFrame();
    }
}
