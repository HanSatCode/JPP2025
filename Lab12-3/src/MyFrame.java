import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {
    private int[] data = {0, 0, 0, 0}; // 사용자의 입력값
    private int[] arcAngle = new int[4];
    private Color[] color = {Color.RED, Color.BLUE, Color.GREEN, Color.ORANGE};
    private String[] itemNames = {"사과", "체리", "딸기", "자두"};
    private JTextField[] textFields = new JTextField[4];
    private ChartPanel chartPanel = new ChartPanel();

    private class InputPanel extends JPanel {
        public InputPanel() {
            this.setBackground(Color.GRAY);
            for(int i = 0; i < textFields.length; i++){
                textFields[i] = new JTextField("0", 5);
                add(new JLabel(itemNames[i])); add(textFields[i]);
                textFields[i].addActionListener(e -> {
                    JTextField tf = (JTextField) e.getSource();
                    int n;
                    try {
                        n = Integer.parseInt(tf.getText());
                    } catch (NumberFormatException ex) {
                        tf.setText("0");
                        return;
                    }
                    drawChart();
                });
            }
        }
    }
    private void drawChart() {
        int sum = 0;
        for(int i = 0; i < data.length; i++){
            data[i] = Integer.parseInt(textFields[i].getText());
            sum += data[i];
        }
        if (sum == 0) return;
        for(int i = 0; i < data.length; i++){
            arcAngle[i] = (int)Math.round( (double) data[i] / sum * 360 );
        }
        chartPanel.repaint();
    }

    private class ChartPanel extends JPanel {
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            int startAngle = 0;
            for(int i = 0; i < data.length; i++){
                g.setColor(color[i]);
                g.drawString(itemNames[i] + " " + Math.round((double) arcAngle[i] / 360 * 100) + "%", 50 + i * 100, 20);
            }
            for(int i = 0; i < data.length; i++){
                g.setColor(color[i]);
                g.fillArc(150, 50, 200, 200, startAngle, arcAngle[i]);
                startAngle += arcAngle[i];
            }
        }
    }
    public MyFrame() {
        super("파이 그래프 그리기");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.add(new InputPanel(), BorderLayout.NORTH);
        c.add(chartPanel, BorderLayout.CENTER);

        setSize(500, 500);
        setVisible(true);
        drawChart();
    }
    public static void main(String[] args) {
        new MyFrame();
    }
}
