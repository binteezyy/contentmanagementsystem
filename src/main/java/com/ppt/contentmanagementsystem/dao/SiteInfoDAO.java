package com.ppt.contentmanagementsystem.dao;

import com.ppt.contentmanagementsystem.model.SiteInfo;
import com.ppt.contentmanagementsystem.repository.SiteInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SiteInfoDAO {

    @Autowired
    SiteInfoRepository siteInfoRepository;

    public List<SiteInfo> getAllSiteInfo(){
        List<SiteInfo> siteInfos = new ArrayList<>();
        siteInfoRepository.findAll()
                .forEach(siteInfos::add);
        return siteInfos;
    }

    public Optional<SiteInfo> getSiteInfo(Long id){
        return siteInfoRepository.findById(id);
    }

    public void addSiteInfo(SiteInfo siteInfo) {
        siteInfoRepository.save(siteInfo);
    }

    public SiteInfo updateSiteInfo(SiteInfo siteInfo){
        Optional<SiteInfo> siopt = siteInfoRepository.findById(siteInfo.getId());
        SiteInfo si = siopt.get();
        si.setSchool_name(siteInfo.getSchool_name());
        si.setVision(siteInfo.getVision());
        si.setMission(siteInfo.getMission());
        si.setObjectives(siteInfo.getObjectives());
        si.setHistory(siteInfo.getHistory());
        siteInfoRepository.save(si);
        return si;
    }

    public void deleteSiteInfo(Long id){
        siteInfoRepository.deleteById(id);
    }
}
