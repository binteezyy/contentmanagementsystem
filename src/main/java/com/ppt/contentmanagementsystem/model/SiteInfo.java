package com.ppt.contentmanagementsystem.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class SiteInfo {

    @Id
    @GeneratedValue
    private Long id;
    private String school_name;
    private String vision;
    private String mission;
    private String objectives;
    private String history;

    public SiteInfo(){

    }

    public SiteInfo(String school_name, String vision, String mission, String objectives, String history){
        super();
        this.school_name = school_name;
        this.vision = vision;
        this.mission = mission;
        this.objectives = objectives;
        this.history = history;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSchool_name() {
        return school_name;
    }

    public void setSchool_name(String school_name) {
        this.school_name = school_name;
    }

    public String getVision() {
        return vision;
    }

    public void setVision(String vision) {
        this.vision = vision;
    }

    public String getMission() {
        return mission;
    }

    public void setMission(String mission) {
        this.mission = mission;
    }

    public String getObjectives() {
        return objectives;
    }

    public void setObjectives(String objectives) {
        this.objectives = objectives;
    }

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }
}
