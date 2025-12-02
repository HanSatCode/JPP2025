import javax.swing.*;
import java.awt.*;

public class TimerRunnable implements Runnable {
    private JLabel timerLabel;

    public TimerRunnable(JLabel timerLabel){
        this.timerLabel = timerLabel;
    }
    @Override
    public void run() {
        int n = 0;
        while(true) {
            timerLabel.setText(String.valueOf(n));
            n++;
            try {
                Thread.sleep(1);
            }
            catch (InterruptedException e){
                return;
            }
        }
    }
}
