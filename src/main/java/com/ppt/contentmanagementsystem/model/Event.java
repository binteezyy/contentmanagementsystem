package com.ppt.contentmanagementsystem.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Event {

    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String description;
    private String date;
    private String start_time;
    private String image_fn;

    public Event(){

    }

    public Event(String title, String description, String date, String start_time, String image_fn){
        super();
        this.title = title;
        this.description = description;
        this.date = date;
        this.start_time = start_time;
        this.image_fn = image_fn;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getImage_fn() {
        return image_fn;
    }

    public void setImage_fn(String image_fn) {
        this.image_fn = image_fn;
    }
}
