package com.ppt.contentmanagementsystem.mvc;

import com.ppt.contentmanagementsystem.dao.EventDAO;
import com.ppt.contentmanagementsystem.dao.NewsDAO;
import com.ppt.contentmanagementsystem.model.Event;
import com.ppt.contentmanagementsystem.model.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Controller
public class NewsVC {

    @Autowired
    NewsDAO newsDAO;

    @GetMapping("/admin/news")
    public String newsHomePage(Model model){
        List<News> news= newsDAO.getAllNews();
        model.addAttribute("news", news);
        model.addAttribute("title", "News List");

        return "newsHome";
    }

    @GetMapping("/admin/news/new")
    public String newNewsPage(Model model){
        Event n = new Event();
        model.addAttribute("n", n);

        return "newsNew";
    }

    @PostMapping("/admin/news/new")
    public String addNewsPage(@ModelAttribute("n") News n){
        newsDAO.addNews(n);

        return "redirect:/admin/news";
    }

    @GetMapping("/admin/news/edit/{id}")
    public String editNewsPage(Model model, @PathVariable Long id){
        Optional<News> nopt = newsDAO.getNews(id);
        News n = nopt.get();
        model.addAttribute("n", n);

        return "newsEdit";
    }

    @PostMapping("/admin/news/update")
    public String updateNewsPage(@ModelAttribute("n") News n){
        newsDAO.updateNews(n);

        return "redirect:/admin/news";
    }

    @GetMapping("/admin/news/imageUpload/{id}")
    public String uploadNewsImagePage(Model model, @PathVariable Long id){
        Optional<News> nopt = newsDAO.getNews(id);
        News n = nopt.get();
        model.addAttribute("n", n);
        model.addAttribute("accept", "image/*");

        return "newsImage";
    }

    @PostMapping("/admin/news/imageUpload")
    public String updateNewsImage(@ModelAttribute("n") News n, @RequestParam("imageFile") MultipartFile imageFile) throws IOException {
        newsDAO.saveNewsImage(n, imageFile);

        return "redirect:/admin/news";
    }

    @GetMapping("/admin/news/delete/{id}")
    public String deleteNewsPage(@PathVariable Long id){
        newsDAO.deleteNews(id);

        return "redirect:/admin/news";
    }
}
