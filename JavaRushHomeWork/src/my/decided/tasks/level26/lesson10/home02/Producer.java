package my.decided.tasks.level26.lesson10.home02;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Overlord on 28.06.15.
 */
public class Producer implements Runnable {
    ConcurrentHashMap<String, String> map;

    public Producer(ConcurrentHashMap<String, String> map) {
        this.map = map;
    }

    @Override
    public void run() {
        try {
            int i = 1;
            while (true) {
                String s= "Some text for " + i;
                map.putIfAbsent(String.valueOf(i),s);
                Thread.sleep(500);
                i++;
            }
        } catch (InterruptedException e) {
            System.out.println(String.format("[%s] thread was terminated", Thread.currentThread().getName()));
        }
    }
}
