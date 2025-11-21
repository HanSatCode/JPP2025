import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MyFrame extends JFrame {
    private int[] units = {50000, 10000, 1000, 500, 100, 50, 10, 1};
    private String[] strOfUnits = {"오만원", "만원", "천원", "오백원", "백원", "오십원", "십원", "일원"};
    private JTextField inputMoney;
    private JTextField[] outputMoneys = new JTextField[8];
    private JCheckBox[] checkBoxes = new JCheckBox[7];

    public MyFrame() {
        setTitle("Money Changer");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();

        JPanel northPanel = new JPanel();
        northPanel.setBackground(Color.YELLOW);

        northPanel.add(new JLabel("금액"));

        inputMoney = new JTextField(8);
        northPanel.add(inputMoney);

        JButton calcBtn = new JButton("계산");
        calcBtn.addActionListener(v -> { // 익명 함수
            String input = inputMoney.getText();
            if(input.length() == 0) return;
            int money = Integer.parseInt(input);
            int res;
            for(int i = 0; i < strOfUnits.length; i++) {
                if (i < checkBoxes.length && !checkBoxes[i].isSelected()) continue;
                res = money / units[i];

                outputMoneys[i].setText(String.valueOf(res));
                if (res > 0) {
                    money = money % units[i];
                } else {
                    outputMoneys[i].setText("0");
               }
            }
        });
        northPanel.add(calcBtn);

        c.add(northPanel, BorderLayout.NORTH);

        //------------------------------------------------------------------------

        JPanel centerPanel = new JPanel();
        centerPanel.setBackground(Color.YELLOW);
        centerPanel.setLayout(new GridLayout(8, 3, 4, 4));
        for (int i = 0; i < strOfUnits.length; i++) {
            JLabel label = new JLabel(strOfUnits[i]);
            label.setHorizontalAlignment(JLabel.RIGHT);
            centerPanel.add(label);

            outputMoneys[i] = new JTextField(10);
            outputMoneys[i].setHorizontalAlignment(JTextField.CENTER);
            outputMoneys[i].setEditable(false);
            centerPanel.add(outputMoneys[i]);
            if (i < checkBoxes.length) {
                checkBoxes[i] = new JCheckBox("", true);
                checkBoxes[i].setOpaque(false);
                centerPanel.add(checkBoxes[i]);
            }
        }

        c.add(centerPanel, BorderLayout.CENTER);
        setSize(300, 300);
        setVisible(true);
    }

    public static void main(String[] args) {
        new MyFrame();
    }
}
