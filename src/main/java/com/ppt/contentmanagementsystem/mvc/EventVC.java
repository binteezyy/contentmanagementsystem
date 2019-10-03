package com.ppt.contentmanagementsystem.mvc;

import com.ppt.contentmanagementsystem.dao.EventDAO;
import com.ppt.contentmanagementsystem.dao.SocialLinkDAO;
import com.ppt.contentmanagementsystem.model.Event;
import com.ppt.contentmanagementsystem.model.SocialLink;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Controller
public class EventVC {

    @Autowired
    EventDAO eventDAO;

    @GetMapping("/admin/events")
    public String eventsHomePage(Model model){
        List<Event> eventsl= eventDAO.getAllEvent();
        model.addAttribute("eventsl", eventsl);
        model.addAttribute("title", "Events List");

        return "eventHome";
    }

    @GetMapping("/admin/events/new")
    public String newEventPage(Model model){
        Event eventl = new Event();
        model.addAttribute("eventl", eventl);

        return "eventNew";
    }

    @PostMapping("/admin/events/new")
    public String addEventPage(@ModelAttribute("eventl") Event eventl){
        eventDAO.addEvent(eventl);

        return "redirect:/admin/events";
    }

    @GetMapping("/admin/events/edit/{id}")
    public String editEventPage(Model model, @PathVariable Long id){
        Optional<Event> eopt = eventDAO.getEvent(id);
        Event eventl = eopt.get();
        model.addAttribute("eventl", eventl);

        return "eventEdit";
    }

    @PostMapping("/admin/events/update")
    public String updateEventPage(@ModelAttribute("eventl") Event eventl){
        eventDAO.updateEvent(eventl);

        return "redirect:/admin/events";
    }

    @GetMapping("/admin/events/imageUpload/{id}")
    public String uploadEventImagePage(Model model, @PathVariable Long id){
        Optional<Event> eopt = eventDAO.getEvent(id);
        Event eventl = eopt.get();
        model.addAttribute("eventl", eventl);
        model.addAttribute("accept", "image/*");

        return "eventImage";
    }

    @PostMapping("/admin/events/imageUpload")
    public String updateEventImage(@ModelAttribute("eventl") Event eventl, @RequestParam("imageFile") MultipartFile imageFile) throws IOException {
        eventDAO.saveEventImage(eventl, imageFile);

        return "redirect:/admin/events";
    }

    @GetMapping("/admin/events/delete/{id}")
    public String deleteEventPage(@PathVariable Long id){
        eventDAO.deleteEvent(id);

        return "redirect:/admin/events";
    }
}
