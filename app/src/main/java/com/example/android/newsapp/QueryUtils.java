package com.example.android.newsapp;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


public final class QueryUtils {

    private final static int CONNECT_TIMEOUT = 1000;
    private final static int READ_TIMEOUT = 1500;

    public static List<News> fetchNewsData(String requestUrl) {
        URL url = createUrl(requestUrl);
        String jsonResponse = null;
        try {
            jsonResponse = makeHttpRequest(url);
        } catch (IOException e) {
            Log.e("fetchNewsData Exception", e.toString());
        }
        return extractNews(jsonResponse);
    }

    private static URL createUrl(String stringUrl) {
        URL url = null;
        try {
            url = new URL(stringUrl);
        } catch (MalformedURLException e) {
            Log.e("createUrl Exception", e.toString());
        }
        return url;
    }

    private static String makeHttpRequest(URL url) throws IOException {
        String jsonResponse = "";
        if (url == null)
            return jsonResponse;
        HttpURLConnection urlConnection = null;
        InputStream inputStream = null;
        try {
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.setConnectTimeout(CONNECT_TIMEOUT);
            urlConnection.setReadTimeout(READ_TIMEOUT);
            urlConnection.connect();

            if (urlConnection.getResponseCode() == 200) {
                inputStream = urlConnection.getInputStream();
                jsonResponse = readFromStream(inputStream);
            }
        } catch (IOException e) {
            Log.e("makeHttpRequ Exception", e.toString());
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
            if (inputStream != null) {
                inputStream.close();
            }
        }
        return jsonResponse;
    }

    private static String readFromStream(InputStream inputStream) {
        StringBuilder builder = new StringBuilder();
        if (inputStream != null) {
            try {
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader reader = new BufferedReader(inputStreamReader);
                String line = reader.readLine();
                while (line != null) {
                    builder.append(line);
                    line = reader.readLine();
                }
            } catch (IOException e) {
                Log.e("readFromStram Exception", e.toString());
            }
        }
        return builder.toString();
    }

    private static List<News> extractNews(String jsonResponse) {
        if (jsonResponse == null || jsonResponse.equals(""))
            return null;
        ArrayList<News> news = new ArrayList<>();
        try {
            JSONObject root = new JSONObject(jsonResponse);
            JSONObject response = root.getJSONObject("response");
            JSONArray results = response.getJSONArray("results");
            for (int i = 0; i < results.length(); i++) {
                JSONObject jsonObject = results.getJSONObject(i);
                String title = jsonObject.getString("webTitle");
                String date = jsonObject.getString("webPublicationDate");
                String section = jsonObject.getString("sectionName");
                String url = jsonObject.getString("webUrl");
                JSONArray tags = jsonObject.getJSONArray("tags");
                String author = "Unknown";
                if (tags.length() > 0) {
                    author = tags.getJSONObject(0).getString("webTitle");
                }
                News temp = new News(title, section,
                        date.substring(0, 10), url, author);
                news.add(temp);
            }
        } catch (JSONException e) {
            Log.e("extractNews Exception", e.toString());
        }
        return news;
    }
}
