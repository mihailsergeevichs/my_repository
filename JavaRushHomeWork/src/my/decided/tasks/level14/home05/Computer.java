package my.decided.tasks.level14.home05;

/**
 * Created by Overlord on 05.06.2015.
 */
public class Computer {
    public Computer() {
        monitor = new Monitor();
        keyboard = new Keyboard();
        mouse = new Mouse();
    }


    public Keyboard getKeyboard() {
        return keyboard;
    }

    public Mouse getMouse() {
        return mouse;
    }

    public Monitor getMonitor() {

        return monitor;
    }

    private Monitor monitor;
    private Mouse mouse;
    private Keyboard keyboard;
}
