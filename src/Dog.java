import java.util.Timer;
import java.util.TimerTask;

public class Dog {

    void toEat (Listener listener){
        System.out.println("The Dog is eating.... ");
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                listener.yaEsta(4);
            }
        }, 5000);

    };
}
