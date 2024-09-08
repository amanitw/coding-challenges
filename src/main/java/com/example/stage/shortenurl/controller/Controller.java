package com.example.stage.shortenurl.controller;

import com.example.stage.shortenurl.algo.CounterBasedIdGenerator;
import com.example.stage.shortenurl.dao.InMemoryStorage;
import com.example.stage.shortenurl.model.Response;
import com.example.stage.shortenurl.model.UrlRequest;
import com.example.stage.shortenurl.service.UrlShortener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URL;

@RestController
public class Controller {

    @Autowired
    private UrlShortener urlShortener;

    @PostMapping("/")
    public ResponseEntity<?> shortenUrl(@RequestBody UrlRequest urlRequest) {
        String url = urlRequest.getUrl();

        if (!isValid(url)) {
            return new ResponseEntity<>("Invalid URL", HttpStatus.BAD_REQUEST);
        }

        String tinyUrl = urlShortener.shortUrl(url);
        Response response = new Response(tinyUrl, url);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> redirectUrl(@PathVariable String id){
        String longUrl = urlShortener.fetchLongUrl(id);
        if (longUrl == null){
            return new ResponseEntity<>("URL NOT FOUND",HttpStatus.resolve(404));
        }

        return new ResponseEntity<>("location: "+longUrl,HttpStatus.FOUND);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteShortUrl(@PathVariable String id){
            String longUrl = urlShortener.removeShortUrl(id);
            if (longUrl == null){
                return new ResponseEntity<>("URL not Found",HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity<>("Deleted Url",HttpStatus.OK);
    }

    private boolean isValid(String url) {
        try {
            new URL(url);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
