package com.pitao.sherwin.smssender;

/**
 * Created by Sherwin on 3/23/2016.
 */
public class MessageData {
    protected String mAddress;
    protected String date;
    protected String body;
    protected int id;
    protected int count;

    public MessageData(String mAddress, String date, String body, int id) {
        this.mAddress = mAddress;
        this.date = date;
        this.body = body;
        this.id = id;
    }
    public MessageData(String mAddress, String date, String body, int id,int count) {
        this.mAddress = mAddress;
        this.date = date;
        this.body = body;
        this.id = id;
        this.count = count;
    }

    public String getmAddress() {
        return mAddress;
    }

    public void setmAddress(String mAddress) {
        this.mAddress = mAddress;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
