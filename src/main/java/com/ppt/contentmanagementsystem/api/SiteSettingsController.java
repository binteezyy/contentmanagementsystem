package com.ppt.contentmanagementsystem.api;

import com.ppt.contentmanagementsystem.dao.SiteSettingDAO;
import com.ppt.contentmanagementsystem.model.SiteSetting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class SiteSettingsController {

    @Autowired
    private SiteSettingDAO siteSettingDAO;

    @GetMapping("/siteSettings")
    public @ResponseBody
    List<SiteSetting> getAllSettings(){
        return siteSettingDAO.getAllSiteSetting();
    }
    @GetMapping("/siteSettings/{id}")
    public @ResponseBody
    Optional<SiteSetting> getSetting(@PathVariable String id){
        return siteSettingDAO.getSiteSetting(id);
    }
}
