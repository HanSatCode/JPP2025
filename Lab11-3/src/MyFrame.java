import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.Vector;

public class MyFrame extends JFrame {
    private RadioPanel radioPanel = new RadioPanel();
    private JLabel imageLabel = new JLabel();
    private Vector<ImageIcon> imageVector = new Vector<>();

    private void loadImages(String path) {
        File file = new File(path);
        File[] files = file.listFiles();
        for(File f : files) {
            if(f.isFile()) {
                ImageIcon icon = new ImageIcon(f.getPath());
                imageVector.add(icon);
                System.out.println("image path : " + f.getPath());
            }
        }
    }

    private class RadioPanel extends JPanel {
        private JRadioButton leftRadio = new  JRadioButton("Left");
        private JRadioButton rightRadio = new  JRadioButton("Right");
        public RadioPanel() {
            setLayout(new FlowLayout());
            ButtonGroup group = new ButtonGroup();
            group.add(leftRadio); group.add(rightRadio);
            add(leftRadio); add(rightRadio);
            leftRadio.setSelected(true);
        }

        public boolean isLeft() {
            return leftRadio.isSelected();
        }
    }

    public MyFrame() {
        super("Image Gallery");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        loadImages("images");

        Container c = getContentPane();
        c.add(radioPanel, BorderLayout.NORTH);
        c.add(imageLabel, BorderLayout.CENTER);
        imageLabel.setIcon(imageVector.get(0));

        int idx = 0;

        radioPanel.addMouseListener(new  MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (radioPanel.isLeft()) {
                    if (idx < 0) {
                        imageLabel.setIcon(imageVector.lastElement());

                    }
                    imageLabel.setIcon(imageVector.get(1));
                }
                else {
                    imageLabel.setIcon(imageVector.get(0));
                }
            }
        });
        imageLabel.addMouseListener(new MyMouseListener(0));
        setSize(400,300);
        setVisible(true);
    }

    private class MyMouseListener extends MouseAdapter {
        private int index;
        public MyMouseListener(int startIndex) {
            index = startIndex;
        }
        public void mouseReleased(MouseEvent e) {
            if (radioPanel.isLeft()) {
                index = ++index % imageVector.size();
                imageLabel.setIcon(imageVector.get(index));
            }
            else { // 오른쪽 방법
                if(--index < 0) index = imageVector.size() - 1;
                imageLabel.setIcon(imageVector.get(index));
            }
        }
    }

    public static void main(String[] args) {
        new MyFrame();
    }
}
