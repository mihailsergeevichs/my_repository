package my.decided.tasks.level27.lesson09.home01;

public class TransferObject {
    private int value;
    protected volatile boolean isValuePresent = false; //use this variable

    public synchronized int get() {
        while(!isValuePresent){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        isValuePresent = true;
        notifyAll();
        System.out.println("Got: " + value);
        return value;
    }

    public synchronized void put(int value) {
        while(isValuePresent){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.value = value;
        isValuePresent = true;
        System.out.println("Put: " + value);
        notifyAll();
    }
}
