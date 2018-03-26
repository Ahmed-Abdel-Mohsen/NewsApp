package com.example.android.newsapp;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by ahmed on 3/24/2018.
 */

public class NewsAdapter extends ArrayAdapter<News> {
    public NewsAdapter(Activity context, ArrayList<News> news) {
        super(context, 0, news);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.news_list_item, parent, false);
        }

        News currentNews = getItem(position);

        TextView titleView = listItemView.findViewById(R.id.news_title);
        titleView.setText(currentNews.getTitle());

        TextView dateView = listItemView.findViewById(R.id.news_date);
        dateView.setText(currentNews.getDate());

        TextView typeView = listItemView.findViewById(R.id.news_type);
        typeView.setText(currentNews.getType());

        TextView authorView = listItemView.findViewById(R.id.news_author);
        authorView.setText(currentNews.getAuthor());

        return listItemView;
    }
}
