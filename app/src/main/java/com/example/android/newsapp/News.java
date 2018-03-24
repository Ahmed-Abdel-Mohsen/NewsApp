package com.example.android.newsapp;

/**
 * Created by ahmed on 3/24/2018.
 */

public class News {
    private String mTitle;
    private String mType;
    private String mDate;
    private String mUrl;

    public News(String title, String type, String date, String url) {
        this.mTitle = title;
        this.mType = type;
        this.mDate = date;
        this.mUrl = url;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        this.mTitle = title;
    }

    public String getType() {
        return mType;
    }

    public void setType(String type) {
        this.mType = type;
    }

    public String getDate() {
        return mDate;
    }

    public void setDate(String date) {
        this.mDate = date;
    }

    public String getUrl() {
        return mUrl;
    }

    public void setUrl(String url) {
        this.mUrl = url;
    }

    @Override
    public String toString() {
        return "News{" +
                "title:" + this.mTitle +
                "\ntype:" + this.mType +
                "\ndate:" + this.mDate +
                "\nurl:" + this.mUrl + "}";
    }
}
