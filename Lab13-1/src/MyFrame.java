import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;

public class MyFrame extends JFrame {
    public MyFrame() {
        super("원을 0.5초...");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(new MyPanel());
        Container c = getContentPane();
        c.add(new JLabel("움직이는 원 패널"));
        c.add(new JButton("끝내기"));

        setSize(300, 300);
        setVisible(true);
    }

    private class MyPanel extends JPanel implements Runnable{
        private int x = 100, y = 100;
        public MyPanel() {
            addMouseListener(new MouseAdapter() {
                private Thread th = null;
                public void mousePressed(MouseEvent e) {
                    if (th == null) {
                        th = new Thread(MyPanel.this);
                        th.start();
                    }
                }
            });
        }
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(Color.MAGENTA);
            g.fillOval(x, y, 50, 50);
        }

        public void run() {
            while (true) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    return;
                }
                x = (int) (Math.random() * (this.getWidth() - 50));
                y = (int) (Math.random() * (this.getHeight() - 50));
                repaint();
            }
        }
    }

    public static void main(String[] args) {
        new MyFrame();
    }
}
