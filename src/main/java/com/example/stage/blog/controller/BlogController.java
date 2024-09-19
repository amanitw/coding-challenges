package com.example.stage.blog.controller;

import com.example.stage.blog.model.BlogPost;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BlogController {

    @GetMapping("/blog")
    public String getBlog(Model model){
        BlogPost b1 = new BlogPost("abc","xed","sds");
        BlogPost b2 = new BlogPost("hfn","jfb","prh");
        List<BlogPost> blogs = new ArrayList<>();
        blogs.add(b1);
        blogs.add(b2);
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
        return "redirect:/blog";
    }

}
