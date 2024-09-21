package com.example.stage.blog.service;

import com.example.stage.blog.dao.BlogRepository;
import com.example.stage.blog.model.BlogPost;
import com.example.stage.blog.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService {
    @Autowired
    private BlogRepository repository;

    public void save(BlogPost blogPost){
        repository.save(blogPost);
    }

    public List<BlogPost> getAll(){
        return repository.fetchAllPost();
    }

    public void addComment(String id,String commentText){
        BlogPost blogPost = repository.fetchBlogPost(id);
        Comment comment = new Comment(commentText);
        blogPost.addComment(comment);
    }

    public BlogPost getBlogPost(String id){
        return repository.fetchBlogPost(id);
    }
}
