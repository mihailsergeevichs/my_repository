package my.decided.tasks.level14.lesson08.home09;

public abstract class Money
{
    public Money(double amount)
    {
        amount = getAmount();
    }
    private double amount = 1d;
    public double getAmount()
    {
        return amount;
    }

    public abstract String getCurrencyName();
}

