package my.decided.tasks.level27.lesson15.big01.kitchen;

/**
 * Created by Overlord on 19.08.2015.
 */
public enum Dish {
    Fish(25),
    Steak(30),
    Soup(15),
    Juice(5),
    Water(3);

    public int getDuration() {
        return duration;
    }

    Dish(int duration){
        this.duration = duration;
    }

    private int duration;

    public static String allDishesToString(){
        StringBuilder sb = new StringBuilder();
        Dish[] values = Dish.values();
        for(Dish dish : values){
            sb.append(dish.toString()).append(", ");
        }
        String result = sb.toString().substring(0, sb.length()-2);
        return result;
    }
}
