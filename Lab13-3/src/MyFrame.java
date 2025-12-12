import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class MyFrame extends JFrame {
    private JLabel southScore = new JLabel("총 블록 수 : 0");
    public MyFrame() {
        super("My Frame");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();

        JLabel northLabel = new JLabel("많이 쌓은 사람이 승리합니다. 좌우키 사용!");

        c.add(northLabel, BorderLayout.NORTH);
        c.add(southScore, BorderLayout.SOUTH);
        c.add(new JLabel("     "), BorderLayout.WEST);
        c.add(new JLabel("     "), BorderLayout.EAST);

        northLabel.setPreferredSize(new Dimension(200, 80));
        northLabel.setHorizontalAlignment(JLabel.CENTER);
        southScore.setPreferredSize(new Dimension(200, 80));
        southScore.setHorizontalAlignment(JLabel.CENTER);

        MyPanel myPanel = new MyPanel();
        c.add(myPanel, BorderLayout.CENTER);

        setSize(300,600);
        setVisible(true);
        
        c.setFocusable(true);
        c.requestFocus();
    }

    private class MyPanel extends JPanel {
        private boolean gameOn = true;
        private int blockCount = 0;
        private Color[] colors = {Color.YELLOW, Color.BLUE, Color.GREEN, Color.RED, Color.ORANGE};
        private final static int ROWS=10, COLS= 5;
        private JLabel[][] labels = new JLabel[ROWS][COLS];
        private int curRow = 0; private int curCol = 0;
        private Color curColor = Color.YELLOW;
        private final Color LINECOLOR = Color.PINK;
        private final Color BASECOLOR = Color.WHITE;

        public MyPanel() {
            setLayout(new GridLayout(ROWS, COLS, 1, 1));
            setBackground(LINECOLOR);
            for(int i = 0; i < labels.length; i++) {
                for(int j = 0; j < labels[i].length; j++) {
                    labels[i][j] = new JLabel();
                    labels[i][j].setOpaque(true);
                    labels[i][j].setBackground(BASECOLOR);
                    add(labels[i][j]);
                }
            }
            addKeyListener(new MyKeyListener());
        }

        public void restart() {
            for(int i = 0; i < labels.length; i++) {
                for(int j = 0; j < labels[i].length; j++) {
                    labels[i][j].setBackground(BASECOLOR);
                }
            }
            blockCount = 0;
        }

        synchronized private void fall() {
            labels[curRow][curCol].setBackground(BASECOLOR);
            curRow++;
            labels[curRow][curCol].setBackground(curColor);
        }

        private boolean canFall() {
            int nextRow = curRow + 1;
            if (nextRow == ROWS) return false; // 바닥
            else if (labels[nextRow][curCol].getBackground() != BASECOLOR) return false; // 블럭이 있음
            else return true;
        }

        private boolean startNewFall() {
            curRow = 0;
            curCol = (int) (Math.random() * COLS);
            if(labels[curRow][curCol].getBackground() != BASECOLOR) {
                // 게임 오버
                southScore.setText("블록 수 : " + blockCount + " 게임 오버");
                return false;
            }
            curColor = colors[(int) (Math.random() * colors.length)];
            labels[curRow][curCol].setBackground(curColor);
            repaint();

            // 블록 수 표시
            southScore.setText("블록 수 : " + blockCount);
            blockCount++;
            return true;
        }

        synchronized public void toLeft() {
            if (curCol == 0) return;
            else if (labels[curRow][curCol - 1].getBackground() != BASECOLOR) return;
            else {
                labels[curRow][curCol].setBackground(BASECOLOR);
                curCol--;
                labels[curRow][curCol].setBackground(curColor);
                repaint();
            }
        }

        synchronized public void toRight() {
            if (curCol == COLS - 1) return;
            else if (labels[curRow][curCol + 1].getBackground() != BASECOLOR) return;
            else {
                labels[curRow][curCol].setBackground(BASECOLOR);
                curCol++;
                labels[curRow][curCol].setBackground(curColor);
                repaint();
            }
        }

        class FallingThread extends Thread {
            @Override
            public void run() {
                gameOn = true;
                startNewFall();
                while(true) {
                    try {
                        if(canFall()) {
                            fall();
                        }
                        else {
                            if(!startNewFall()) {
                                gameOn = false; return;
                            }
                        }
                        sleep(50);
                    } catch (InterruptedException e) {
                        return;
                    }
                }
            }

            class MyKeyListener extends KeyAdapter {
                public void keyPressed(KeyEvent e) {
                    int keyCode = e.getKeyCode();
                    if(gameOn = false) {
                        if(keyCode == KeyEvent.VK_ENTER) restart();
                        else return;
                    }
                    switch(keyCode) {
                        case KeyEvent.VK_LEFT -> toLeft();
                        case KeyEvent.VK_RIGHT -> toRight();
                        default -> {}
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        new MyFrame();
    }
}
