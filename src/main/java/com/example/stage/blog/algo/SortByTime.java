package com.example.stage.blog.algo;

import com.example.stage.blog.model.BlogPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
public class SortByTime implements SortBlogs{

    @Autowired
    private SortComparator comparator;
    @Override
    public List<BlogPost> sort(List<BlogPost> blogPosts) {
        Collections.sort(blogPosts,comparator);
        return blogPosts;
    }
}
