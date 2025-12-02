import java.awt.*;
import java.awt.event.*;
import java.util.Vector;
import javax.swing.*;

public class MyFrame extends JFrame {
    private class Circle {
        private int x, y;
        private int radius;

        public Circle(int x, int y, int radius) {
            this.x = x;
            this.y = y;
            this.radius = radius;
        }

        public Point getLeftTopPoint() {
            return new Point(x - radius, y - radius);
        }

        public int getHeight() {
            return radius;
        }
        public int getRadius() {
            return radius * 2;
        }
    }

    public MyFrame() {
        setTitle("예제");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(new MyPanel());
        setSize(800, 500);
        setVisible(true);
    }

    private class MyPanel extends JPanel {
        private Vector<Circle> circleVector = new Vector<>();
        private Circle circleDragged = null;

        public MyPanel() {
            MyMouseListener myMouseListener = new MyMouseListener();
            addMouseListener(myMouseListener);
            addMouseMotionListener(myMouseListener);
        }

        private class MyMouseListener extends MouseAdapter {    // 클릭 및 드래그 이벤트를 다 갖고 있음
            private Point startP = null;
            public void mousePressed(MouseEvent e) {
                startP = e.getPoint();
            }
            public void mouseReleased(MouseEvent e) {
                Point endP = e.getPoint();
                double pow = (endP.x - startP.x) * (endP.x - startP.x) + (endP.y - startP.y) * (endP.y - startP.y);
                int radius = (int) Math.sqrt(pow);
                circleVector.add(new Circle(startP.x, startP.y, radius));
                repaint();
            }
            public void mouseDragged(MouseEvent e) {
                Point endP = e.getPoint();
                double pow = ((endP.x - startP.x) * (endP.x - startP.x)) + ((endP.y - startP.y) * (endP.y - startP.y));
                int radius = (int) Math.sqrt(pow);
                circleDragged = new Circle(startP.x, startP.y, radius);
                repaint();
            }
        }

        public void paintComponent(Graphics g) {
            super.paintComponent(g); // 원래 있던 것을 그대로 그림
            g.setColor(Color.MAGENTA); // 여기서부터는 추가적인 요소
            for (Circle c : circleVector) {
                Point p = c.getLeftTopPoint();
                g.drawOval(p.x, p.y, c.getHeight(), c.getHeight());
            }
            if (circleDragged != null) {
                g.setColor(Color.BLUE);
                Point p = circleDragged.getLeftTopPoint();
                g.drawOval(p.x, p.y, circleDragged.getHeight(), circleDragged.getHeight());
            }
        }
    }

    public static void main(String[] args) {
        new MyFrame();
    }
}
