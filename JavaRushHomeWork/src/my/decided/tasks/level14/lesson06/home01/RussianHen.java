package my.decided.tasks.level14.lesson06.home01;

/**
 * Created by Overlord on 05.06.2015.
 */
public class RussianHen extends Hen {
    @Override
    public int getCountOfEggsPerMonth() {
        return 4;
    }
    String getDescription()
    {
        return super.getDescription() + " Моя страна - " + Country.RUSSIA + ". Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.";
    }
}
