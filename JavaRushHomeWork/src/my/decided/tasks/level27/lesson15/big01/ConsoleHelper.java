package my.decided.tasks.level27.lesson15.big01;

import my.decided.tasks.level27.lesson15.big01.kitchen.Dish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Overlord on 19.08.2015.
 */
public class ConsoleHelper {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() throws IOException {
        return reader.readLine();
    }

    public static List<Dish> getAllDishesForOrder() throws IOException {
        ConsoleHelper.writeMessage("Please choose your dishes:");
        List<Dish> dishes = new ArrayList<>();
        String dishName;
        while (!"exit".equals(dishName = readString())) {
            try {
                dishes.add(Dish.valueOf(dishName));
            } catch (IllegalArgumentException e){
                ConsoleHelper.writeMessage(dishName + " is not detected");
            }
        }
        return dishes;
    }
}


