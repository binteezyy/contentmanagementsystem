package com.ppt.contentmanagementsystem.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TextContent {

    @Id
    String category;
    String description;

    public TextContent(){

    }

    public TextContent(String category, String description){
        super();
        this.category = category;
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
