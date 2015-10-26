package my.decided.tasks.level21.lesson16.big01;

/**
 * Created by Overlord on 18.06.2015.
 */
public class Horse {
    public String name;
    public double distance;
    public double speed;

    public Horse(String name, double speed, double distance) {
        this.name = name;
        this.speed = speed;
        this.distance = distance;
    }
    public void move(){
        distance += Math.random() * speed;
    }
    public void print(){
        for(int i = 0; i < Math.round(distance); i++)
        {
            System.out.print(".");
        }
        System.out.println(getName());
    }

    public double getDistance() {
        return distance;
    }

    public String getName() {
        return name;
    }

    public double getSpeed() {
        return speed;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }
}
