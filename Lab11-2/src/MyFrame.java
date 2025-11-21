import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MyFrame extends JFrame {
    JSlider slider = new JSlider(JSlider.HORIZONTAL, 1,100,50);
    private JLabel label = new JLabel("Love Java");

    public MyFrame() {
        setTitle("JSlider Practice Frame");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();

        //------------------------------------------------------------------------

        JPanel northPanel = new JPanel();

        slider.setMajorTickSpacing(20); slider.setMinorTickSpacing(5);
        slider.setPaintLabels(true); slider.setPaintTicks(true);
        slider.addChangeListener(e -> {
            JSlider source = (JSlider) e.getSource();
            label.setFont(new Font("Gothic", Font.BOLD, source.getValue()));
        });

        northPanel.add(slider);
        c.add(northPanel, BorderLayout.NORTH);

        //------------------------------------------------------------------------

        JPanel centerPanel = new JPanel();
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setFont(new Font("Gothic", Font.BOLD, slider.getValue()));

        centerPanel.add(label);
        c.add(centerPanel, BorderLayout.CENTER);

        //------------------------------------------------------------------------

        setSize(600, 300);
        setVisible(true);
    }

    public static void main(String[] args) {
        new MyFrame();
    }
}
