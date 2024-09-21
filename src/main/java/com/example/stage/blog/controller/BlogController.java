package com.example.stage.blog.controller;

import com.example.stage.blog.algo.SortBlogs;
import com.example.stage.blog.model.BlogPost;
import com.example.stage.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
public class BlogController {

    @Autowired
    private BlogService blogService;

    @Autowired
    private SortBlogs sortBlogs;

    @GetMapping("/blog")
    public String getBlog(Model model){
        List<BlogPost> blogs = sortBlogs.sort(blogService.getAll());
        model.addAttribute("posts",blogs);
        return "index";
    }

    @GetMapping("/editor")
    public String showEditor() {
        return "editor";
    }

    @GetMapping("/login")
    public String login() {
        return "login";  // This maps to the login.html template in src/main/resources/templates
    }

    @GetMapping("/editor/post")
    public String showPostForm(Model model){
        model.addAttribute("blogPost",new BlogPost());
        return "post_form";
    }


    @PostMapping("/editor/post")
    public String savePost(@ModelAttribute BlogPost blogPost){
        blogPost.setId(UUID.randomUUID().toString());
        blogService.save(blogPost);
        return "redirect:/blog";
    }


    @GetMapping("/editor/post/edit/{id}")
    public String showEditForm(@PathVariable String id, Model model) {
        BlogPost blogPost = blogService.getBlogPost(id);
        model.addAttribute("blogPost", blogPost);
        return "edit_post_form";
    }

    @PostMapping("/editor/post/edit/{id}")
    public String updatePost(@PathVariable String id, @ModelAttribute BlogPost blogPost) {
        blogPost.setId(id);
       // blogPost.setPublishedDate(blogPost.getPublishedDate() != null ? blogPost.getPublishedDate() : LocalDateTime.now());  // Set or update published date
        blogService.save(blogPost);  // Save the updated post
        return "redirect:/blog";  // Redirect to the blog list
    }

    @PostMapping("/posts/{id}/comment")
    public String showCommentForm(@PathVariable String id, @RequestParam("comment") String commentText){
        blogService.addComment(id,commentText);
        return "redirect:/blog";
    }
}
