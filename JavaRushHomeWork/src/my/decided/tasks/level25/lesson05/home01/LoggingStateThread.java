package my.decided.tasks.level25.lesson05.home01;

/**
 * Created by Overlord on 26.06.15.
 */
public class LoggingStateThread extends Thread {
    Thread thread;
    public LoggingStateThread(Thread thread) {
        this.thread = thread;
        setDaemon(true);
    }



    public void run()
    {
        State state = thread.getState();
        System.out.println(state);
        while (state != State.TERMINATED)
        {
            if (state != thread.getState())
            {
                state = thread.getState();
                System.out.println(state);
            }
        }
    }
}
