package com.ppt.contentmanagementsystem.dao;

import com.ppt.contentmanagementsystem.model.Event;
import com.ppt.contentmanagementsystem.model.News;
import com.ppt.contentmanagementsystem.repository.EventRepository;
import com.ppt.contentmanagementsystem.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class NewsDAO {
    @Autowired
    NewsRepository newsRepository;

    public List<News> getAllNews(){
        List<News> news = new ArrayList<>();
        newsRepository.findAll()
                .forEach(news::add);
        return news;
    }

    public Optional<News> getNews(Long id){
        return newsRepository.findById(id);
    }

    public void addNews(News news){
        newsRepository.save(news);
    }

    public News updateNews(News n){
        Optional<News> nopt = newsRepository.findById(n.getId());
        News news = nopt.get();
        news.setId(n.getId());
        news.setTitle(n.getTitle());
        news.setDescription(n.getDescription());
        news.setDate(n.getDate());
        newsRepository.save(news);
        return news;
    }

    public void saveNewsImage(News n, MultipartFile imageFile) throws IOException {
        Path currentPath = Paths.get(".");
        Path absolutePath = currentPath.toAbsolutePath();
        String uploadPath = absolutePath + "/src/main/resources/static/uploads/";
        long datetime = System.currentTimeMillis();
        String dt = Long.toString(datetime);
        byte[] bytes =  imageFile.getBytes();
        Path path = Paths.get(uploadPath + dt + imageFile.getOriginalFilename());
        Files.write(path,bytes);
        n.setImage_fn(dt + imageFile.getOriginalFilename());
        newsRepository.save(n);
    }

    public void deleteNews(Long id){
        newsRepository.deleteById(id);
    }
}
