package my.decided.tasks.level27.lesson04.home01;

public class ThreadDeadlock {
    Object data;
    public synchronized Object getData() {
        synchronized (data){
        return data;
        }
    }
}
