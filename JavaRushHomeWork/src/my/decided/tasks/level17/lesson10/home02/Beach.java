package my.decided.tasks.level17.lesson10.home02;

/* Comparable
Реализуйте интерфейс Comparable<Beach> в классе Beach, который будет использоваться нитями.
*/

public class Beach implements Comparable<Beach> {
    private String name;      //название
    private float distance;   //расстояние
    private int quality;    //качество

    public Beach(String name, float distance, int quality) {
        this.name = name;
        this.distance = distance;
        this.quality = quality;
    }

    public synchronized String getName() {
        return name;
    }

    public synchronized void setName(String name) {
        this.name = name;
    }

    public synchronized float getDistance() {
        return distance;
    }

    public synchronized void setDistance(float distance) {
        this.distance = distance;
    }

    public synchronized int getQuality() {
        return quality;
    }

    public synchronized void setQuality(int quality) {
        this.quality = quality;
    }

    @Override
    public synchronized int compareTo(Beach beach) {

        int distanceParam = (int) (distance - beach.getDistance());
        int qualityParam = quality - beach.getQuality();
        return 10000 * name.compareTo(beach.getName()) + 100 * distanceParam + qualityParam;
    }
    public static void main(String[] args)
    {
        Beach beach1 = new Beach("beach", 1.0f, 2);
        Beach beach2 = new Beach("beach", 2.0f, 1);
        beach1.compareTo(beach2);
    }
}
