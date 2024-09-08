package com.example.stage.shortenurl.service;

import com.example.stage.shortenurl.algo.IdGenerator;
import com.example.stage.shortenurl.dao.Storage;
import org.springframework.stereotype.Service;


public class UrlShortener {
    private IdGenerator idGenerator;
    private String baseUrl = "http://tinyurl.com/";
    private Storage storage;

    public UrlShortener(IdGenerator idGenerator, Storage storage) {
        this.idGenerator = idGenerator;
        this.storage = storage;
    }

    public String shortUrl(String longUrl) {
        String tinyUrl = storage.getShortUrl(longUrl);
        if (tinyUrl != null) {
            return tinyUrl;
        }

        String encodedString = idGenerator.generate();
        tinyUrl = baseUrl + encodedString;
        storage.put(tinyUrl, longUrl);
        return tinyUrl;
    }

    public String fetchLongUrl(String id){
        String shortUrl = baseUrl+id;
        String longUrl = storage.getLongUrl(shortUrl);
        return longUrl;
    }

    public String removeShortUrl(String id){
        String shortUrl = baseUrl+id;
        String longUrl = storage.getLongUrl(shortUrl);
        if (longUrl == null){
            return null;
        }
        storage.removeUrl(shortUrl);
        return longUrl;
    }
}
