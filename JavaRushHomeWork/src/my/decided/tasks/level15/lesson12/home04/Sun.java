package my.decided.tasks.level15.lesson12.home04;

/**
 * Created by Overlord on 06.06.2015.
 */
public class Sun implements Planet {

    private static Sun sun;

    private Sun(){}

    public static Sun getInstance(){
        if(sun == null){
            sun = new Sun();
        }
        return sun;
    }
}
