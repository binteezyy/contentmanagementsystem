package com.ppt.contentmanagementsystem.api;

import com.ppt.contentmanagementsystem.dao.NewsDAO;
import com.ppt.contentmanagementsystem.model.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:80", maxAge = 3600)
@RestController
public class NewsController {

    @Autowired
    private NewsDAO newsDAO;

    @GetMapping("/news")
    public @ResponseBody
    List<News> getAllNews(){
        return newsDAO.getAllNews();
    }

    @GetMapping("/news/{id}")
    public @ResponseBody
    Optional<News> getNews(@PathVariable Long id){
        return newsDAO.getNews(id);
    }
}
