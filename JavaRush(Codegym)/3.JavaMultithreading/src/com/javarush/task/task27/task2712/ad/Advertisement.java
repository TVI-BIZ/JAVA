package com.javarush.task.task27.task2712.ad;

public class Advertisement {
    private Object content;

    public String getName() {
        return name;
    }
    public int getDuration() {
        return duration;
    }
    public long getAmountPerOneDisplaying() {
        return amountPerOneDisplaying;
    }



    private String name;
    private long initialAmount;

    public int getHits() {
        return hits;
    }

    private int hits;
    private int duration;



    private long amountPerOneDisplaying;

    public Advertisement(Object content, String name, long initialAmount, int hits, int duration) {
        this.content = content;
        this.name = name;
        this.initialAmount = initialAmount;
        this.hits = hits;
        this.duration = duration;
        this.amountPerOneDisplaying = hits>0?initialAmount/hits:0;

    }
    public void revalidate(){
        if(hits < 0){
            throw new NoVideoAvailableException();
        }
        hits --;


    }

}
