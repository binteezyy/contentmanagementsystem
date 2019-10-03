package com.ppt.contentmanagementsystem.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class College {

    @Id
    private String id;
    private String name;
    private String image_fn;
    private String description;
    private Long telno;
    private Long faxno;
    private String email;
    private String address;


    @OneToMany(mappedBy = "college", cascade= CascadeType.ALL)
    private List<Department> departments;

    public College(){

    }

    public College(String id, String name, String image_fn, String description, Long telno, Long faxno, String email, String address){
        super();
        this.id = id;
        this.name = name;
        this.image_fn = image_fn;
        this.description = description;
        this.telno = telno;
        this.faxno = faxno;
        this.email = email;
        this.address = address;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getTelno() {
        return telno;
    }

    public void setTelno(Long telno) {
        this.telno = telno;
    }

    public Long getFaxno() {
        return faxno;
    }

    public void setFaxno(Long faxno) {
        this.faxno = faxno;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }
}