package com.example.stage.blog.algo;

import com.example.stage.blog.model.BlogPost;
import org.springframework.stereotype.Component;

import java.util.Comparator;

@Component
public class SortComparator implements Comparator<BlogPost> {
    @Override
    public int compare(BlogPost o1, BlogPost o2) {
        return o2.getPublishedDateTime().compareTo(o1.getPublishedDateTime());
    }
}
