package com.example.stage.shortenurl.dao;

public interface Storage {
    public void put(String shortUrl,String longUrl);
    public String getShortUrl(String longUrl);
    public String getLongUrl(String shortUrl);
}
