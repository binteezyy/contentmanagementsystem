package com.ppt.contentmanagementsystem.model;

import javax.persistence.*;
import java.util.Optional;

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

    public Employee (int id, String name, String designation, String credentials){
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

    public String getDepartment() {
        return department.getName();
    }

    public void setDepartment(Department byId) {
        this.department = byId;
    }
}