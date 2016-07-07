package io.nevermore.brvahdemo.util;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import io.nevermore.brvahdemo.entity.News;

/**
 * Created by Lee on 2016/7/5.
 */
public class JsonParser {
    public static List<News> parserNewsList(JSONArray array) throws JSONException {
        List<News> newses = new ArrayList<>();
        for (int i = 0; i < array.length(); i++) {
            JSONObject obj =array.getJSONObject(i);
            News news = new News();
            news.setId(obj.getInt("id"));
            news.setTitle(obj.getString("title"));
            news.setImage(obj.getString("images"));
            newses.add(news);
        }
        return newses;
    }
}
