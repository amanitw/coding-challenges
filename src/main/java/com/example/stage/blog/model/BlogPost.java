package com.example.stage.blog.model;

import java.time.LocalDateTime;
import java.util.UUID;

public class BlogPost {
    private String id;
    private String title;
    private String summary;
    private String post;

    private LocalDateTime publishedDateTime;

    public BlogPost() {
    }

    public BlogPost(String title, String summary, String post) {
        this.id = UUID.randomUUID().toString();
        this.title = title;
        this.summary = summary;
        this.post = post;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getPublishedDateTime() {
        return publishedDateTime;
    }

    public void setPublishedDateTime(LocalDateTime publishedDateTime) {
        this.publishedDateTime = publishedDateTime;
    }
}
