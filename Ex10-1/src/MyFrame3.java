import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MyFrame3 extends JFrame {
    private JLabel la = new JLabel("Hello Java");
    public MyFrame3() {
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
                    MyFrame3.this.setTitle(b.getText());
                }
        );
        la.setSize(120, 20);
        la.setLocation(100, 100);
        c.add(la);
        c.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Component c = (Component) e.getSource();
                if (e.getClickCount() == 1 && e.getButton() == MouseEvent.BUTTON3) {
                    c.setBackground(Color.ORANGE);
                }
                else if (e.getClickCount() == 2) {
                    c.setBackground(Color.BLUE);
                }
                else if (e.getClickCount() == 3) {
                    c.setBackground(Color.RED);
                }
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

        c.setFocusable(true);
        c.requestFocus();
        c.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();
                switch (keyCode) {
                    case KeyEvent.VK_UP:
                        la.setLocation(la.getX(), la.getY() - 10);
                        break;
                    case KeyEvent.VK_DOWN:
                        la.setLocation(la.getX(), la.getY() + 10);
                        break;
                    case KeyEvent.VK_LEFT:
                        la.setLocation(la.getX() - 10, la.getY());
                        break;
                    case KeyEvent.VK_RIGHT:
                        la.setLocation(la.getX() + 10, la.getY());
                }
            }
        });
    }

    public static void main(String[] args) {
        new  MyFrame3();
    }
}