import java.util.Timer;
import java.util.TimerTask;

public class Uploader {

    public void upload (Listener listener) {

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                listener.yaEsta();
            }
        }, 5000);

    }
}
