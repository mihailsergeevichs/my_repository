package my.decided.tasks.level27.lesson15.big01.kitchen;



import java.util.Observable;
import java.util.Observer;

/**
 * Created by Overlord on 19.08.2015.
 */
public class Cook extends Observable implements Observer {
    String name;

    public Cook(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }



    @Override
    public void update(Observable o, Object arg) {
        System.out.println("Start cooking - " + arg + ", cooking time " + ((Order)arg).getTotalCookingTime() + "min");
        setChanged();
        notifyObservers(arg);
    }
}
