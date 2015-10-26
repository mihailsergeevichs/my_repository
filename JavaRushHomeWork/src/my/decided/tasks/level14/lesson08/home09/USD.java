package my.decided.tasks.level14.lesson08.home09;

/**
 * Created by Overlord on 05.06.2015.
 */
public class USD extends Money {
    public USD(double amount) {
        super(amount);
    }

    @Override
    public String getCurrencyName() {
        return "USD";
    }
}
