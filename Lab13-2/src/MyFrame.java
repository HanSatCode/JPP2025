import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class MyFrame extends JFrame {
    public MyFrame() {
        super("흔들리는 컴포넌트");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container c = getContentPane();
        c.setLayout(null);

        JLabel myLabel = new JLabel("흔들리는 레이블");
        myLabel.setLocation(100, 100);
        myLabel.setSize(150, 20);
        c.add(myLabel);

        setSize(300, 300);
        setLocation(100, 100);
        setVisible(true);

        ViberatingTread vp = new ViberatingTread(this); // 내 자신을 줌
        vp.start();
        ViberatingTread vp2 = new ViberatingTread(myLabel);
        vp2.start();
    }

    private class ViberatingTread extends Thread {
        private Component comp;
        public ViberatingTread(Component comp) {
            this.comp = comp;
        }

        @Override
        public void run() {
            Random r = new Random(); // 유틸리티 패키지
            int x = comp.getX(); int y = comp.getY();
            while(true) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    return;
                }
                int signX = r.nextBoolean() ? 1 : -1;
                int tempX = x + r.nextInt(5) * signX;
                int signY = r.nextBoolean() ? 1 : -1;
                int tempY = y + r.nextInt(5) * signY;
                comp.setLocation(tempX, tempY);
            }
        }
    }
    public static void main(String[] args) {
        new MyFrame();
    }
}
