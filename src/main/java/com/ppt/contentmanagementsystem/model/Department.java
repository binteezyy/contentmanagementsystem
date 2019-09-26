package com.ppt.contentmanagementsystem.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class Department {

    @Id
    private String name;
    private String description;
    @ManyToOne
    @JoinColumn(name="college_name")
    private College college;

    @OneToMany(mappedBy = "department", cascade=CascadeType.ALL)
    private List<Employee> employees;

    public Department(){

    }

    public Department(String name, String description){
        super();
        this.name = name;
        this.description = description;
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

    public String getCollegeId() {
        return college.getId();
    }

    @JsonIgnore
    public String getCollegeName() { return college.getName(); }

    @JsonIgnore
    public College getCollege(){
        return college;
    }

    public void setCollege(College college) {
        this.college = college;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
