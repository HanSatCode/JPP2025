import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MyFrame extends JFrame {
    public MyFrame() {
        setTitle("블럭 이동 예제");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        Container c =  getContentPane();
        c.add(new JLabel("상하좌우 방향키로"), BorderLayout.NORTH);
        CenterPanel centerPanel = new CenterPanel();
        c.add(centerPanel, BorderLayout.CENTER);

        setSize(300, 320);
        setVisible(true);

        centerPanel.setFocusable(true);
        centerPanel.requestFocus();
    }

    private class CenterPanel extends JPanel {
        private final static int ROWS = 5, COLS = 5;
        private JLabel[][] labels = new JLabel[ROWS][COLS];
        private int curRow = 2, curCol = 2;

        public CenterPanel() {
            setLayout(new GridLayout(ROWS, COLS, 1, 1));
            setBackground(Color.PINK);
            for(int i = 0; i < labels.length; i++) {
                for(int j = 0; j < labels[i].length; j++) {
                    labels[i][j] = new JLabel();
                    labels[i][j].setOpaque(true); // 텍스트 배경을불투명하게 만듦
                    labels[i][j].setBackground(Color.WHITE);
                    add(labels[i][j]);
                }
            }
            labels[curRow][curCol].setBackground(Color.BLUE);

            this.addKeyListener(new KeyAdapter() {
                public void keyPressed(KeyEvent e) {
                    int keyCode=  e.getKeyCode();
                    switch(keyCode) {
                        case KeyEvent.VK_LEFT:
                            if(curCol == 0) break;
                            labels[curRow][curCol].setBackground(Color.WHITE);
                            curCol--;
                            labels[curRow][curCol].setBackground(Color.BLUE);
                            break;
                        case KeyEvent.VK_RIGHT:
                            if(curCol == COLS - 1) break;
                            labels[curRow][curCol].setBackground(Color.WHITE);
                            curCol++;
                            labels[curRow][curCol].setBackground(Color.BLUE);
                            break;
                        case KeyEvent.VK_UP:
                            if(curRow == 0) break;
                            labels[curRow][curCol].setBackground(Color.WHITE);
                            curRow--;
                            labels[curRow][curCol].setBackground(Color.BLUE);
                            break;
                        case KeyEvent.VK_DOWN:
                            if(curRow == ROWS - 1) break;
                            labels[curRow][curCol].setBackground(Color.WHITE);
                            curRow++;
                            labels[curRow][curCol].setBackground(Color.BLUE);
                            break;
                    }
                }
            });
        }
    }

    public static void main(String[] args) {
        new MyFrame();
    }
}
