package com.ppt.contentmanagementsystem.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class SocialLink {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String url;
    private String image_fn;

    public SocialLink(){

    }

    public SocialLink(String name, String url, String image_fn){
        super();
        this.name = name;
        this.url = url;
        this.image_fn = image_fn;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImage_fn() {
        return image_fn;
    }

    public void setImage_fn(String image_fn) {
        this.image_fn = image_fn;
    }
}
