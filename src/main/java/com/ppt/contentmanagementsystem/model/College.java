package com.ppt.contentmanagementsystem.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class College {

    @Id
    String id;
    String name;
    String image_fn;

    @OneToMany(mappedBy = "college", cascade= CascadeType.ALL)
    private List<Department> departments;

    public College(){

    }

    public College(String id, String name, String image_fn){
        super();
        this.id = id;
        this.name = name;
        this.image_fn = image_fn;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage_fn() {
        return image_fn;
    }

    public void setImage_fn(String image_fn) {
        this.image_fn = image_fn;
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }
}