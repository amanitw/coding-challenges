package com.example.stage.blog.controller;

import com.example.stage.blog.model.BlogPost;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
