/*import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame {
    public MyFrame() {
        setTitle("이벤트 예제");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(new FlowLayout());
        JButton btn = new JButton("Action");
        c.add(btn);
        btn.addActionListener( e -> {
                JButton b = (JButton) e.getSource();
                if(b.getText().equals("Action")){
                    b.setText("액션");
                }
                else {
                    b.setText("Action");
                }
                MyFrame.this.setTitle(b.getText());
            }
        );
        setSize(400, 300);
        setVisible(true);
    }

    //public static void main(String[] args) {
        //new  MyFrame();
    //}
}
*/