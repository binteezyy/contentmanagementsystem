package com.ppt.contentmanagementsystem.api;


import com.ppt.contentmanagementsystem.dao.EventDAO;
import com.ppt.contentmanagementsystem.model.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:80", maxAge = 3600)
@RestController
public class EventController {

    @Autowired
    private EventDAO eventDAO;

    @GetMapping("/events")
    public @ResponseBody
    List<Event> getAllEvent(){
        return eventDAO.getAllEvent();
    }

    @GetMapping("/events/{id}")
    public @ResponseBody
    Optional<Event> getEvent(@PathVariable Long id){
        return eventDAO.getEvent(id);
    }
}
