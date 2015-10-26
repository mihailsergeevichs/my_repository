package my.decided.tasks.level25.lesson07.home01;



public class TaskManipulator implements Runnable, CustomThreadManipulator {
    Thread t;
    String name;

    @Override
    public void run() {
        try {
            while (!t.isInterrupted()) {
                Thread.sleep(0);
                System.out.println(name);
                Thread.sleep(90);
            }
        } catch (InterruptedException e) {}
    }

    @Override
    public void start(String threadName) {
        this.name = threadName;
        t = new Thread(this);
        t.start();
    }

    @Override
    public void stop() {
        t.interrupt();
    }
}
