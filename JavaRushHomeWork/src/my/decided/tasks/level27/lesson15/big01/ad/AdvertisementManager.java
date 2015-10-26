package my.decided.tasks.level27.lesson15.big01.ad;



import my.decided.tasks.level27.lesson15.big01.ConsoleHelper;

import java.util.*;

/**
 * Created by Overlord on 20.08.2015.
 */
public class AdvertisementManager {
    private final AdvertisementStorage storage = AdvertisementStorage.getInstance();
    private int timeSeconds;
    public AdvertisementManager(int timeSeconds) {
        this.timeSeconds = timeSeconds;
    }
    public AdvertisementStorage getStorage() {
        return storage;
    }
    public void processVideos() {
        List<Advertisement> videos = storage.list();
        if (storage.list().isEmpty()) {
            throw new NoVideoAvailableException();
        } else {
            List<Advertisement> chosen_List = fakeRecursion(videos);
            Collections.sort(chosen_List, new Comparator<Advertisement>() {
                @Override
                public int compare(Advertisement o1, Advertisement o2) {
                    if (o2.getAmountPerOneDisplaying() == o1.getAmountPerOneDisplaying()) {
                        return (int) (1000 * o1.getAmountPerOneDisplaying() / o1.getDuration() - 1000 * o2.getAmountPerOneDisplaying() / o2.getDuration());
                    } else {
                        return (int) (o2.getAmountPerOneDisplaying() - o1.getAmountPerOneDisplaying());
                    }
                }
            });
            for (Advertisement ad : chosen_List) {
                ad.revalidate();
                ConsoleHelper.writeMessage(String.format("%s is displaying... %d, %d", ad.getName(), ad.getAmountPerOneDisplaying(), 1000 * ad.getAmountPerOneDisplaying() / ad.getDuration()));
            }
        }
    }
    public List<Advertisement> fakeRecursion(final List<Advertisement> advertisements) {
        List<List<Advertisement>> result = combinations(advertisements);
        List<List<Advertisement>> tmp = new ArrayList<>(result);
        for (List<Advertisement> list : tmp) {
            int duration = 0;
            for (Advertisement ad : list) {
                duration += ad.getDuration();
            }
            for (Advertisement ad : list) {
                if(ad.getAmountPerOneDisplaying()==0.0){
                    result.remove(list);
                }
            }
            if (duration > timeSeconds) {
                result.remove(list);
            }
        }
        Collections.sort(result, new Comparator<List<Advertisement>>() {
            @Override
            public int compare(List<Advertisement> o1, List<Advertisement> o2) {
                int revenue1 = 0;
                int duration1 = 0;
                for (Advertisement ad : o1) {
                    revenue1 += ad.getAmountPerOneDisplaying();
                    duration1 += ad.getDuration();
                }
                int revenue2 = 0;
                int duration2 = 0;
                for (Advertisement ad : o2) {
                    revenue2 += ad.getAmountPerOneDisplaying();
                    duration2 += ad.getDuration();
                }
                if (revenue1 == revenue2 && duration1 != duration2) {
                    return duration2 - duration1;
                } else if (revenue1 == revenue2 && duration1 == duration2) {
                    return o1.size() - o2.size();
                } else {
                    return revenue2 - revenue1;
                }
            }
        });
        return result.isEmpty()? new ArrayList<Advertisement>() : result.get(0);
    }
    public List<List<Advertisement>> combinations(final List<Advertisement> advertisements) {
        if (advertisements.size() > 1) {
            List<List<Advertisement>> result = new ArrayList<List<Advertisement>>();
            for (Advertisement adv : advertisements) {
                result.add(new ArrayList<Advertisement>(Arrays.asList(adv)));
                List<Advertisement> subAdvert = new ArrayList<Advertisement>(advertisements);
                subAdvert.remove(adv);
                for (List<Advertisement> tmp : combinations(subAdvert)) {
                    tmp.add(adv);
                    result.add(tmp);
                }
            }
            return result;
        } else {
            List<List<Advertisement>> result = new ArrayList<List<Advertisement>>();
            result.add(new ArrayList<Advertisement>(advertisements));
            return result;
        }
    }
}