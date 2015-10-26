package my.decided.tasks.level27.lesson15.big01;


import my.decided.tasks.level27.lesson15.big01.kitchen.Cook;
import my.decided.tasks.level27.lesson15.big01.kitchen.Waitor;


/**
 * Created by Overlord on 19.08.2015.
 */
public class Restaurant {
    public static void main(String[] args) {
        Cook amigoCook = new Cook("Amigo");
        Waitor waitor = new Waitor();
        amigoCook.addObserver(waitor);
        Tablet tablet = new Tablet(5);
        tablet.addObserver(amigoCook);
        tablet.createOrder();
    }
}
