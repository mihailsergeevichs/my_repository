package my.decided.tasks.level30.lesson04.home01;

import java.util.concurrent.TransferQueue;

/**
 * Created by Overlord on 23.08.2015.
 */
public class Consumer implements Runnable {

    private TransferQueue<ShareItem> queue;

    public Consumer(TransferQueue<ShareItem> queue){
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(500);
            while (true){
                ShareItem item = queue.take();
                System.out.println("Processing " + item.toString());
            }
        } catch (InterruptedException e) {
            return;
        }
    }
}
