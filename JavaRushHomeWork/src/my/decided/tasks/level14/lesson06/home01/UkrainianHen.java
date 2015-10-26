package my.decided.tasks.level14.lesson06.home01;

/**
 * Created by Overlord on 05.06.2015.
 */
public class UkrainianHen extends Hen{
    @Override
    public int getCountOfEggsPerMonth() {
        return 3;
    }
    String getDescription()
    {
        return super.getDescription() + " Моя страна - " + Country.UKRAINE + ". Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.";
    }
}
