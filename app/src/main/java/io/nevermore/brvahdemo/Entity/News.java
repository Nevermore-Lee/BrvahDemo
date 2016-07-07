package io.nevermore.brvahdemo.entity;

import java.io.Serializable;

/**
 * Created by Lee on 2016/7/5.
 */
public class News implements Serializable {
    private int id;
    private String title;
    private String image;
    private String date;

    public News() {
    }

    public News(int id, String title, String image,String date) {
        this.id = id;
        this.title = title;
        this.image = image;
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getId() {

        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getImage() {
        return image;
    }
}
