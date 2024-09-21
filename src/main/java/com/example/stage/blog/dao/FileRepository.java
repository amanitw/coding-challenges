package com.example.stage.blog.dao;

import com.example.stage.blog.model.BlogPost;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class FileRepository implements BlogRepository{
    private String filepath = "blogs.json";
    private ObjectMapper objectMapper = new ObjectMapper();
    public FileRepository() {
        File file = new File(filepath);
        if (!file.exists()) {
            try {
                objectMapper.writeValue(file, new ArrayList<>()); // Create an empty JSON array if the file doesn't exist
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    @Override
    public void save(BlogPost blogPost) {
        List<BlogPost> allPosts = getAllPost();
        allPosts.add(blogPost);
        saveAll(allPosts);
    }

    @Override
    public List<BlogPost> fetchAllPost() {
        return getAllPost();
    }

    @Override
    public BlogPost fetchBlogPost(String id) {
        List<BlogPost> allBlogPost = getAllPost();
        return allBlogPost.stream()
                .filter(blogPost -> blogPost.getId().equals(id))
                .findFirst()
                .get();
    }

    private List<BlogPost> getAllPost() {
        try {
            File file = new File(filepath);
            List<BlogPost> allBlog = objectMapper.readValue(file, new TypeReference<List<BlogPost>>() {
            });
            return allBlog;
        }catch (Exception e){
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    private void saveAll(List<BlogPost> blogPosts){
        try {
            File file = new File(filepath);
            objectMapper.writeValue(file,blogPosts);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
