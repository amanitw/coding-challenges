package com.example.stage.shortenurl.dao;

import java.util.HashMap;
import java.util.Map;

public class InMemoryStorage implements Storage{
    private Map<String,String> shortToLongUrlMap = new HashMap<>();
    private Map<String,String> longToShortUrlMap = new HashMap<>();
    @Override
    public void put(String shortUrl, String longUrl) {
        shortToLongUrlMap.put(shortUrl,longUrl);
        longToShortUrlMap.put(longUrl,shortUrl);
    }

    @Override
    public String getShortUrl(String longUrl) {
        return longToShortUrlMap.get(longUrl);
    }

    @Override
    public String getLongUrl(String shortUrl) {
        return shortToLongUrlMap.get(shortUrl);
    }
}
