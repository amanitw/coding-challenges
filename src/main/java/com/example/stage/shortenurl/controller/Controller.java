package com.example.stage.shortenurl.controller;

import com.example.stage.shortenurl.algo.CounterBasedIdGenerator;
import com.example.stage.shortenurl.dao.InMemoryStorage;
import com.example.stage.shortenurl.model.Response;
import com.example.stage.shortenurl.model.UrlRequest;
import com.example.stage.shortenurl.service.UrlShortener;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    private UrlShortener urlShortener = new UrlShortener(new CounterBasedIdGenerator(), new InMemoryStorage());

    @PostMapping("/")
    public Response shortenUrl(@RequestBody UrlRequest urlRequest) {
        String url = urlRequest.getUrl();
        String tinyUrl = urlShortener.shortUrl(url);
        Response response = new Response(tinyUrl, url);
        return response;
    }
}
