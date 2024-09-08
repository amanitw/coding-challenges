package com.example.stage.shortenurl.service;

import com.example.stage.shortenurl.algo.IdGenerator;
import com.example.stage.shortenurl.dao.Storage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UrlShortener {
    @Autowired
    private IdGenerator idGenerator;
    private String baseUrl = "http://tinyurl.com/";
    @Autowired
    private Storage storage;

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
