package com.ppt.contentmanagementsystem.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.lang.Nullable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Employee {

    @Id
    private String name;
    private String designation;
    private String credentials;
    private String image_fn;

    @ManyToOne()
    @JoinColumn(name="department_name")
    private Department department;

    public Employee (){

    }

    public Employee (String name, String designation, String credentials, String image_fn, Department dept){
        super();
        this.name = name;
        this.designation = designation;
        this.credentials = credentials;
        this.image_fn = image_fn;
        this.department = dept;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getCredentials() {
        return credentials;
    }

    public void setCredentials(String credentials) {
        this.credentials = credentials;
    }

    public String getImage_fn() {
        return image_fn;
    }

    public void setImage_fn(String image_fn) {
        this.image_fn = image_fn;
    }

    public String getDepartmentName() {
        String returnValue;
        try{
            returnValue = department.getName();
        } catch (Exception e) {
            returnValue = "Empty";
            e.printStackTrace();
        }
        return returnValue;
    }

    @JsonIgnore
    public Department getDepartment(){
        return department;
    }

    public void setDepartment(Department byId) {
        this.department = byId;
    }

}