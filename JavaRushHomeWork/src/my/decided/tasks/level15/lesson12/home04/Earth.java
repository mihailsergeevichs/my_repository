package my.decided.tasks.level15.lesson12.home04;

/**
 * Created by Overlord on 06.06.2015.
 */
public class Earth implements Planet {

    private static Earth earth;

    private Earth(){}

    public static Earth getInstance(){
        if(earth == null){
            earth = new Earth();
        }
        return earth;
    }
}