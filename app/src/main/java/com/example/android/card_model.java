package com.example.android;

public class card_model {

    String news, item, total;


    public card_model(String news, String item, String total) {
        this.news = news;
        this.item = item;
        this.total = total;
    }



    public String getNews() {
        return news;
    }

    public void setNews(String news) {
        this.news = news;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

     }



