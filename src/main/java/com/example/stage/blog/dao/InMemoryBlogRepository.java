package com.example.stage.blog.dao;

import com.example.stage.blog.model.BlogPost;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
@Primary
public class InMemoryBlogRepository implements BlogRepository {
    private Map<String,BlogPost> postMap = new HashMap<>();

    @Override
    public void save(BlogPost blogPost) {
        blogPost.setPublishedDateTime(LocalDateTime.now());
        postMap.put(blogPost.getId(), blogPost);
    }

    @Override
    public List<BlogPost> fetchAllPost() {
        return postMap.entrySet().stream()
                .map(stringBlogPostEntry -> stringBlogPostEntry.getValue())
                .collect(Collectors.toList());
    }

    @Override
    public BlogPost fetchBlogPost(String id) {
        return postMap.get(id);
    }
}
