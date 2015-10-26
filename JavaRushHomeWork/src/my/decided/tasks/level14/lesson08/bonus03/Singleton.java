package my.decided.tasks.level14.lesson08.bonus03;

/**
 * Created by Overlord on 05.06.2015.
 */
public class Singleton {
    public static Singleton getInstance()
    {
        return Singleton.singleton;
    }
    private Singleton(){}
    static Singleton singleton = new Singleton();
}
