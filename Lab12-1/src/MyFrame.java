import java.awt.*;
import java.awt.event.*;
import java.util.Vector;
import javax.swing.*;
import javax.swing.event.*;

public class MyFrame extends JFrame {
    public MyFrame() {
        setTitle("예제");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(new MyPanel());
        setSize(500, 500);
        setVisible(true);
    }

    private class MyPanel extends JPanel {
        private Vector<Integer> vx = new Vector<>(); // x좌표
        private Vector<Integer> vy = new Vector<>(); // y좌표
        public MyPanel() {
            this.addMouseListener(new MouseAdapter() {
                public void mousePressed(MouseEvent e) {
                    if (e.getButton() == MouseEvent.BUTTON3) {
                        vx.clear(); vy.clear();
                    }
                    else if (e.getButton() == MouseEvent.BUTTON2) {
                        vx.removeLast(); vy.removeLast();
                    }
                    else {
                        vx.add(e.getX());
                        vy.add(e.getY());
                    }
                    repaint();
                }
            });
        }

        public void paintComponent(Graphics g) {
            super.paintComponent(g); // 원래 있던 것을 그대로 그림
            g.setColor(Color.MAGENTA); // 여기서부터는 추가적인 요소
            int[] ax = new int[vx.size()];
            int[] ay = new int[vy.size()];
            for (int i = 0; i < ax.length; i++) {
                ax[i] = vx.get(i);
                ay[i] = vy.get(i);
            }
            g.drawPolygon(ax, ay, vx.size());
        }
    }

    public static void main(String[] args) {
        new MyFrame();
    }
}
