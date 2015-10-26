package my.decided.tasks.level27.lesson15.big01.ad;

/**
 * Created by Overlord on 20.08.2015.
 */
public class Advertisement
{
    private Object content; //Video
    private String name;    //Name
    private long initialAmount; //Advertisement total price
    private int hits;   //Number of needed payed plays
    private int duration;   //Duration of video in seconds
    private long amountPerOneDisplaying;    //Money for one displaying
    public Advertisement(Object content, String name, long initialAmount, int hits, int duration)
    {
        this.content = content;
        this.name = name;
        this.initialAmount = initialAmount;
        this.hits = hits;
        this.duration = duration;
        amountPerOneDisplaying = initialAmount / hits;
    }
    /**
     * Decreases hits
     */
    public void revalidate()throws UnsupportedOperationException {
        if (hits <= 0) {
            throw new UnsupportedOperationException();
        }
        hits--;
        if (hits == 1) {
            amountPerOneDisplaying += initialAmount % amountPerOneDisplaying;
        }
    }// if amountPerOneDisplaying in constructor was rounded }
    public String getName()
    {
        return name;
    }
    public int getDuration()
    {
        return duration;
    }
    public long getAmountPerOneDisplaying()
    {
        return amountPerOneDisplaying;
    }
}