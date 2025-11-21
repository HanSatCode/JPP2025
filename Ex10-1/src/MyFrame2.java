/*import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MyFrame2 extends JFrame {
    private JLabel la = new JLabel("Hello Java");
    public MyFrame2() {
        setTitle("이벤트 예제");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container c = getContentPane();
        //c.setLayout(new FlowLayout());
        c.setLayout(null);
        JButton btn = new JButton("Action");
        btn.setSize(90, 20);
        btn.setLocation(150, 50);
        c.add(btn);
        btn.addActionListener( e -> {
                    JButton b = (JButton) e.getSource();
                    if(b.getText().equals("Action")){
                        b.setText("액션");
                    }
                    else {
                        b.setText("Action");
                    }
                    MyFrame2.this.setTitle(b.getText());
                }
        );
        la.setSize(120, 20);
        la.setLocation(100, 100);
        c.add(la);
        c.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();
                la.setLocation(x, y);
            }
        });
        c.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                la.setLocation(e.getX(), e.getY());
            }
            @Override
            public void mouseDragged(MouseEvent e) {
                la.setLocation(e.getX(), e.getY());
            }
        });
        setSize(400, 300);
        setVisible(true);
    }

    public static void main(String[] args) {
        new  MyFrame2();
    }
}*/