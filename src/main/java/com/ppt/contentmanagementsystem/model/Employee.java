package com.ppt.contentmanagementsystem.model;

import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity
public class Employee {

    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    @Id
    private String name;
    private String designation;
    private String credentials;

    public Employee (){

    }

    public Employee (int id, String name, String designation, String credentials){
        super();
        this.id = id;
        this.name = name;
        this.designation = designation;
        this.credentials = credentials;
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
}