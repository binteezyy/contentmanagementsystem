package com.ppt.contentmanagementsystem.dao;

import com.ppt.contentmanagementsystem.model.Event;
import com.ppt.contentmanagementsystem.repository.EventRepository;
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
public class EventDAO {

    @Autowired
    EventRepository eventRepository;

    public List<Event> getAllEvent(){
        List<Event> events = new ArrayList<>();
        eventRepository.findAll()
                .forEach(events::add);
        return events;
    }

    public Optional<Event> getEvent(Long id){
        return eventRepository.findById(id);
    }

    public void addEvent(Event event){
        eventRepository.save(event);
    }

    public Event updateEvent(Event e){
        Optional<Event> eopt = eventRepository.findById(e.getId());
        Event event = eopt.get();
        event.setId(e.getId());
        event.setTitle(e.getTitle());
        event.setDescription(e.getDescription());
        event.setDate(e.getDate());
        event.setStart_time(e.getStart_time());
        eventRepository.save(event);
        return event;
    }

    public void saveEventImage(Event e, MultipartFile imageFile) throws IOException {
        Path currentPath = Paths.get(".");
        Path absolutePath = currentPath.toAbsolutePath();
        String uploadPath = absolutePath + "/src/main/resources/static/uploads/";
        long datetime = System.currentTimeMillis();
        String dt = Long.toString(datetime);
        byte[] bytes =  imageFile.getBytes();
        Path path = Paths.get(uploadPath + dt + imageFile.getOriginalFilename());
        Files.write(path,bytes);
        e.setImage_fn(dt + imageFile.getOriginalFilename());
        eventRepository.save(e);
    }

    public void deleteEvent(Long id){
        eventRepository.deleteById(id);
    }
}
