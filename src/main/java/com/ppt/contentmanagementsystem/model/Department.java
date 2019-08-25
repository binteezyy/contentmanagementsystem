package com.ppt.contentmanagementsystem.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Department {

    private int id;
    @Id
    private String name;
    private String description;

    public Department(){

    }

    public Department(int id, String name, String description){
        super();
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
