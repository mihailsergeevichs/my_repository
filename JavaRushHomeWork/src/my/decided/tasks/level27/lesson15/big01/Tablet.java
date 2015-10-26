package my.decided.tasks.level27.lesson15.big01;

import my.decided.tasks.level27.lesson15.big01.ad.AdvertisementManager;
import my.decided.tasks.level27.lesson15.big01.ad.NoVideoAvailableException;
import my.decided.tasks.level27.lesson15.big01.kitchen.Order;

import java.io.IOException;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Overlord on 19.08.2015.
 */
public class Tablet extends Observable
{
    final int number;
    public static Logger logger = Logger.getLogger(Tablet.class.getName());
    public Tablet(int number) {
        this.number = number;
    }
    public void createOrder(){
        try {
            Order order = new Order(this);
            ConsoleHelper.writeMessage(order.toString());
            if (!order.isEmpty()){
                setChanged();
                notifyObservers(order);
                try {
                    AdvertisementManager manager = new AdvertisementManager(order.getTotalCookingTime() * 60);
                    manager.processVideos();
                } catch (NoVideoAvailableException e) {
                    logger.log(Level.INFO, "No video is available for the order " + order);
                }
            }
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Console is unavailable.");
        }
    }
    @Override
    public String toString()
    {
        return "Tablet{" +
                "number=" + number +
                '}';
    }
}
