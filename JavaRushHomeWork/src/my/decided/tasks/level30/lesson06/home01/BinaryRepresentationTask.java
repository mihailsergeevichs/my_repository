package my.decided.tasks.level30.lesson06.home01;

import java.util.concurrent.RecursiveTask;

/**
 * Created by Overlord on 23.08.2015.
 */
public class BinaryRepresentationTask extends RecursiveTask<String> {
    final int i;
    final int b;
    public BinaryRepresentationTask(int i) {
        this.i = i;
        b = 0;
    }

    @Override
    protected String compute() {
        int a = i % 2;
        int b = i / 2;
        String result = String.valueOf(a);
        if (b > 0)
        {
            BinaryRepresentationTask task = new BinaryRepresentationTask(a);
            task.fork();
            return new BinaryRepresentationTask(b).compute() + task.join();
        }
        return result;
    }
}
