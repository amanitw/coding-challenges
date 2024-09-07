package com.example.stage.post.cache;

import com.example.stage.post.model.Post;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class FileCache implements Cache{
    private ObjectMapper objectMapper = new ObjectMapper();
    @Override
    public List<Post> read(String filePath) throws IOException {
        File file = new File(filePath);
        return objectMapper.readValue(file, new TypeReference<List<Post>>() {
        });
    }

    @Override
    public String write(List<Post> posts) throws IOException {
        String fileName = "local_cache.json";
        File file = new File(fileName);
        objectMapper.writeValue(file,posts);
        return fileName;
    }
}
