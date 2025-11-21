import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MyFrame extends JFrame {
    private class CardLabel extends JLabel {
        private int number;
        private final static Color NORMAL_COLOR = Color.YELLOW;
        private final static Color SELECTED_COLOR = Color.MAGENTA;
        public CardLabel(int number) {
            super(String.valueOf(number));  // Integer.toString(number)
            this.number = number;
            setOpaque(true);
            setBackground(NORMAL_COLOR);
            setFont(new Font("Gothic", Font.BOLD, 20));
            setHorizontalAlignment(JLabel.CENTER);
        }

        public int getNumber() {
            return number;
        }

        public void setNumber(int number) {
            this.number = number;
            setText(String.valueOf(number));
        }

        public void selected() {
            setBackground(SELECTED_COLOR);
        }

        public void deSelected() {
            setBackground(NORMAL_COLOR);
        }
    }

    private class MyPanel extends JPanel {
        private CardLabel[] cardLabels = new CardLabel[12];
        public MyPanel() {
            setLayout(new GridLayout(3, 4, 10, 10));
            MyMouseListener myMouseListener = new MyMouseListener();
            for(int i = 0 ; i < cardLabels.length; i++) {
                cardLabels[i] = new CardLabel(i + 1);
                this.add(cardLabels[i]);
                cardLabels[i].addMouseListener(myMouseListener);
            }
        }

        class MyMouseListener extends MouseAdapter {
            private CardLabel firstCard = null;
            private CardLabel[] prev = new CardLabel[2];
            public MyMouseListener() {
                prev[0] = prev[1] = null;
            }

            @Override
            public void mousePressed(MouseEvent e) {
                if(firstCard == null) {
                    if(prev[0] != null) {
                        prev[0].deSelected();
                        prev[1].deSelected();
                    }
                    firstCard = (CardLabel)e.getComponent();
                    firstCard.selected();
                    prev[0] = firstCard;
                }
                else {
                    CardLabel secondCard = (CardLabel)e.getComponent();
                    secondCard.selected();
                    prev[1] = secondCard;
                    int temp = firstCard.getNumber();
                    firstCard.setNumber(secondCard.getNumber());
                    secondCard.setNumber(temp);
                    firstCard = null;
                }
            }
        }
    }
    public MyFrame() {
        setTitle("카드 스위치 게임");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.add(new MyPanel(), BorderLayout.NORTH);
        setSize(300, 200);
        setVisible(true);
    }

    public static void main(String[] args) {
        new MyFrame();
    }
}
