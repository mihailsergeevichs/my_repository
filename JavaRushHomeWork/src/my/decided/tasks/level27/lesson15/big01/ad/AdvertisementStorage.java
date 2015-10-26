package my.decided.tasks.level27.lesson15.big01.ad;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Overlord on 20.08.2015.
 */
class AdvertisementStorage {

    private static AdvertisementStorage ourInstance = new AdvertisementStorage();
    public static AdvertisementStorage getInstance() {
        return ourInstance;
    }

    private AdvertisementStorage() {
        Object someContent = new Object();
        add(new Advertisement(someContent, "First Video", 5000, 100, 3 * 60)); // 3 min
        add(new Advertisement(someContent, "Second Video", 100, 10, 15 * 60)); //15 min
        add(new Advertisement(someContent, "Third Video", 400, 2, 10 * 60));   //10 min
    }

    private final List<Advertisement> videos = new ArrayList<Advertisement>();

    public List<Advertisement> list(){
        return videos;
    }
    public void add(Advertisement advertisement){
        videos.add(advertisement);
    }

}
