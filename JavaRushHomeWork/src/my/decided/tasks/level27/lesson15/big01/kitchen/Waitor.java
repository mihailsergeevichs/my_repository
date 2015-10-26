package my.decided.tasks.level27.lesson15.big01.kitchen;

import my.decided.tasks.level27.lesson15.big01.ConsoleHelper;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by Overlord on 20.08.2015.
 */
public class Waitor implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        ConsoleHelper.writeMessage(arg + " was cooked by " + o.toString());
    }
}
