package it.filieri.app.dto;

import java.util.ArrayList;

public class Centralina {
    private Channel channel;
    private ArrayList<Feeds> feeds;

    public Channel getChannel() {
        return channel;
    }

    public void setChannel(Channel channel) {
        this.channel = channel;
    }

    public ArrayList<Feeds> getFeeds() {
        return feeds;
    }

    public void setFeeds(ArrayList<Feeds> feeds) {
        this.feeds = feeds;
    }
}
