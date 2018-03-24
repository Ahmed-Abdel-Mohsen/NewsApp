package com.example.android.newsapp;

import android.content.AsyncTaskLoader;
import android.content.Context;

import java.util.List;

/**
 * Created by ahmed on 3/24/2018.
 */

public class NewsLoader extends AsyncTaskLoader<List<News>> {

    private String REQUEST_URL;

    public NewsLoader(Context context, String requestUrl) {
        super(context);
        REQUEST_URL = requestUrl;
    }

    @Override
    public List<News> loadInBackground() {
        List<News> news = QueryUtils.fetchNewsData(REQUEST_URL);
        return news;
    }

    @Override
    protected void onStartLoading() {
        onForceLoad();
    }
}
