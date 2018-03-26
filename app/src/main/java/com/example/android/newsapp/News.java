package com.example.android.newsapp;



public class News {
    private String mTitle;
    private String mSection;
    private String mDate;
    private String mUrl;
    private String mAuthor;

    public News(String title, String type, String date, String url, String author) {
        this.mTitle = title;
        this.mSection = type;
        this.mDate = date;
        this.mUrl = url;
        this.mAuthor = author;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        this.mTitle = title;
    }

    public String getType() {
        return mSection;
    }

    public void setType(String type) {
        this.mSection = type;
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

    public String getAuthor() {
        return mAuthor;
    }

    public void setAuthor(String author) {
        this.mAuthor = author;
    }

    @Override
    public String toString() {
        return "News{" +
                "title:" + this.mTitle +
                "\ntype:" + this.mSection +
                "\ndate:" + this.mDate +
                "\nurl:" + this.mUrl + "}";
    }
}
