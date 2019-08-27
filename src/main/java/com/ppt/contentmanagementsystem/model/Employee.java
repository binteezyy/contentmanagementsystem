package com.ppt.contentmanagementsystem.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

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

    @ManyToOne()
    @JoinColumn(name="department_name")
    private Department department;

    public Employee (){

    }

    public Employee (String name, String designation, String credentials){
        super();
        this.name = name;
        this.designation = designation;
        this.credentials = credentials;
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

    public String getDepartmentName() {
        return department.getName();
    }

    @JsonIgnore
    public Department getDepartment(){
        return department;
    }

    public void setDepartment(Department byId) {
        this.department = byId;
    }
}