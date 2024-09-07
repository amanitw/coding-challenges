package com.example.stage.post.cache;

import com.example.stage.post.model.Post;

import java.io.IOException;
import java.util.List;

public interface Cache {
    public List<Post> read(String filePath) throws IOException;
    public String write(List<Post> posts) throws IOException;
}
