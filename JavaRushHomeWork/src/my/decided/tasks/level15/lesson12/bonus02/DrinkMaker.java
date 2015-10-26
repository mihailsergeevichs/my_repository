package my.decided.tasks.level15.lesson12.bonus02;

/**
 * Created by Overlord on 06.06.2015.
 */
public abstract class DrinkMaker
{
    abstract void getRightCup();

    abstract void putIngredient();

    abstract void pour();

    void makeDrink()
    {
        getRightCup();
        putIngredient();
        pour();
    }
}