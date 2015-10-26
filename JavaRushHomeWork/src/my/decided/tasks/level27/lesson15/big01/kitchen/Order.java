package my.decided.tasks.level27.lesson15.big01.kitchen;

import my.decided.tasks.level27.lesson15.big01.ConsoleHelper;
import my.decided.tasks.level27.lesson15.big01.Tablet;

import java.io.IOException;
import java.util.List;

/**
 * Created by Overlord on 19.08.2015.
 */
public class Order {
    List<Dish> dishes;
    Tablet tablet;
    public Order(Tablet tablet) throws IOException {
        this.tablet = tablet;
        this.dishes = ConsoleHelper.getAllDishesForOrder();
    }

    public int getTotalCookingTime(){
        int total = 0;
        for(Dish dish : dishes){
            total = total + dish.getDuration();
        }
        return total;
    }

    public boolean isEmpty(){
        return dishes.isEmpty();
    }

    @Override
    public String toString() {
        if (dishes.isEmpty()){
            return new String();
        }
        else {
            String s = "";
            for(Dish dish : dishes){
                s = s + dish + ", ";
            }
            String dishes = s.substring(0, s.length()-2);
            String result = "Your order: [" + dishes + "] of " + this.tablet.toString();
            return result;
        }
    }


}
