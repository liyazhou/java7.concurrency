package me.liyazhou.java7.concurrency.ch1.demo07_daemon;

import java.util.Date;

/**
 * Created by liyazhou on 2015/7/1.
 */
public class Event {
    private Date date;
    private String event;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }
}
