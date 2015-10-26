package my.decided.tasks.level28.lesson06.home01;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Overlord on 20.08.2015.
 */
public class MyThread extends Thread {
    static int currentPriority = 1;

    public MyThread() {
        int priority = getPriority(this);
        this.setPriority(priority);
    }

    public MyThread(ThreadGroup group, String name) {

        super(group, name);

        this.setPriority(getPriority(this));
    }

    public MyThread(ThreadGroup group, Runnable target) {
        super(group, target);

        this.setPriority(getPriority(this));
    }

    public MyThread(ThreadGroup group, Runnable target, String name) {
        super(group, target, name);
        this.setPriority(getPriority(this));
    }

    public MyThread(ThreadGroup group, Runnable target, String name, long stackSize) {
        super(group, target, name, stackSize);
        this.setPriority(getPriority(this));
    }

    public MyThread(String name) {
        super(name);
        this.setPriority(getPriority(this));
    }

    public MyThread(Runnable target) {
        super(target);

        this.setPriority(getPriority(this));
    }

    public MyThread(Runnable target, String name) {
        super(target, name);
        this.setPriority(getPriority(this));
    }

    static int getThreadGroupPriority(Thread t){
        if(t.getThreadGroup() != null){
            return t.getThreadGroup().getMaxPriority();
        }
        else return 0;
    }
    static int getPriority(Thread t){
        int result = 0;
        int cur = currentPriority;
        currentPriority++;
        if(cur == 10){
                currentPriority = 1;
            }
            int j = getThreadGroupPriority(t);
            if(cur >= j){
                result = j;
            }
            else{
                result = cur;
            }

        return result;
    }
}
