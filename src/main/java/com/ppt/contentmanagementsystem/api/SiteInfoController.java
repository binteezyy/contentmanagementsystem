package com.ppt.contentmanagementsystem.api;

import com.ppt.contentmanagementsystem.dao.SiteInfoDAO;
import com.ppt.contentmanagementsystem.model.SiteInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:80", maxAge = 3600)
@RestController
public class SiteInfoController {

    @Autowired
    private SiteInfoDAO siteInfoDAO;

    @GetMapping("/infos")
    public @ResponseBody
    List<SiteInfo> getAllSiteInfo(){
        return siteInfoDAO.getAllSiteInfo();
    }

    @GetMapping("/infos/{id}")
    public @ResponseBody
    Optional<SiteInfo> getSiteInfo(@PathVariable Long id){
        return siteInfoDAO.getSiteInfo(id);
    }
}
