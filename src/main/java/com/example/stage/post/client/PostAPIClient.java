package com.example.stage.post.client;

import com.example.stage.post.model.Post;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PostAPIClient {
    private static final String API_URL = "https://jsonplaceholder.typicode.com/posts";
    private ObjectMapper objectMapper = new ObjectMapper();
    public List<Post> fetchPost() throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(API_URL).openConnection();
      //  httpURLConnection.setRequestProperty("Accept","application/json");

        if (httpURLConnection.getResponseCode() == 200){
            StringBuilder response = new StringBuilder();
            Scanner scanner = new Scanner(httpURLConnection.getInputStream());

            while (scanner.hasNextLine()){
                response.append(scanner.nextLine());
            }

            return objectMapper.readValue(response.toString(), new TypeReference<List<Post>>() {
            });
        }
        return new ArrayList<>();
    }
}
