package com.DiliGruop.bean;

import java.io.Serializable;

/**
 * Created by Kevin on 2016/5/13.
 */
public class AD_Banner implements Serializable {

    private String id; //  id
    private String date; //
    private String title; //
    private String url; //

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
