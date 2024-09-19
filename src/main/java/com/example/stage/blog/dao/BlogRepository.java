package com.example.stage.blog.dao;

import com.example.stage.blog.model.BlogPost;

import java.util.List;

public interface BlogRepository {
    public void save(BlogPost blogPost);
    public List<BlogPost> fetchAllPost();
    public BlogPost fetchBlogPost(String id);
}
