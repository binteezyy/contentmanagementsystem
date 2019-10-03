package com.ppt.contentmanagementsystem.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class SiteSetting {

    @Id
    private String id;
    private String mainIconFn;
    private String negativeIconFn;
    private String iconLongFn;
    private String themeName;
    private String smsUrl;
    private String admissionUrl;
    private String headerOne;
    private String headerTwo;
    private String headermp4;
    private String footer;

    public SiteSetting(){

    }

    public SiteSetting(String mainIconFn, String negativeIconFn, String iconLongFn, String themeName, String smsUrl, String admissionUrl, String headerOne, String headerTwo, String headermp4, String footer){
        super();
        this.mainIconFn = mainIconFn;
        this.negativeIconFn = negativeIconFn;
        this.iconLongFn = iconLongFn;
        this.themeName = themeName;
        this.smsUrl = smsUrl;
        this.admissionUrl = admissionUrl;
        this.headerOne = headerOne;
        this.headerTwo = headerTwo;
        this.headermp4 = headermp4;
        this.footer = footer;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMainIconFn() {
        return mainIconFn;
    }

    public void setMainIconFn(String mainIconFn) {
        this.mainIconFn = mainIconFn;
    }

    public String getNegativeIconFn() {
        return negativeIconFn;
    }

    public void setNegativeIconFn(String negativeIconFn) {
        this.negativeIconFn = negativeIconFn;
    }

    public String getIconLongFn() {
        return iconLongFn;
    }

    public void setIconLongFn(String iconLongFn) {
        this.iconLongFn = iconLongFn;
    }

    public String getThemeName() {
        return themeName;
    }

    public void setThemeName(String themeName) {
        this.themeName = themeName;
    }

    public String getSmsUrl() {
        return smsUrl;
    }

    public void setSmsUrl(String smsUrl) {
        this.smsUrl = smsUrl;
    }

    public String getAdmissionUrl() {
        return admissionUrl;
    }

    public void setAdmissionUrl(String admissionUrl) {
        this.admissionUrl = admissionUrl;
    }

    public String getHeaderOne() {
        return headerOne;
    }

    public void setHeaderOne(String headerOne) {
        this.headerOne = headerOne;
    }

    public String getHeaderTwo() {
        return headerTwo;
    }

    public void setHeaderTwo(String headerTwo) {
        this.headerTwo = headerTwo;
    }

    public String getHeadermp4() {
        return headermp4;
    }

    public void setHeadermp4(String headermp4) {
        this.headermp4 = headermp4;
    }

    public String getFooter() {
        return footer;
    }

    public void setFooter(String footer) {
        this.footer = footer;
    }
}
