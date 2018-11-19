package com.example.darqwski.secondapplication;

/**
 * Created by Darqwski on 2018-11-19.
 */

public class Article {
    String title;
    String address;
    String pubDate;
    String desc;

    public Article(String title, String address, String desc, String pubDate) {
        this.title = title;
        this.address = address;
        this.desc = desc;
        this.pubDate = pubDate;
    }

    public Article(String title) {
        this.title = title;
    }
}
