package com.javarush.task.task27.task2712.ad;

import java.util.ArrayList;
import java.util.List;

public class AdvertisementStorage {
    private static AdvertisementStorage single_instance = null;
    private final List<Advertisement> videos = new ArrayList();



    private AdvertisementStorage() {
        Object someContent = new Object();
        videos.add(new Advertisement(someContent, "First Video", 5000,
                98, 3 * 60)); // 3 min
        videos.add(new Advertisement(someContent, "Second Video", 100,
                10, 15 * 60)); //15 min
        videos.add(new Advertisement(someContent, "Third Video", 400,
                2, 10 * 60)); //10 min
        videos.add(new Advertisement(someContent, "Fourth Video", 400,
                2, 8 * 60)); //8 min
        videos.add(new Advertisement(someContent, "Fifth Video", 400,
                2, 10 * 60)); //10 min

    }


    public static AdvertisementStorage getInstance(){
        if(single_instance == null){
            single_instance = new AdvertisementStorage();
        }
        return single_instance;
    }

    public List<Advertisement> list(){
        return videos;
    }
    public void add(Advertisement advertisement){
        videos.add(advertisement);
    }
}
