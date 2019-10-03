package com.ppt.contentmanagementsystem.dao;

import com.ppt.contentmanagementsystem.model.SiteSetting;
import com.ppt.contentmanagementsystem.repository.SiteSettingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SiteSettingDAO {

    @Autowired
    SiteSettingRepository siteSettingRepository;

    public List<SiteSetting> getAllSiteSetting(){
        List<SiteSetting> siteSettings = new ArrayList<>();
        siteSettingRepository.findAll()
                .forEach(siteSettings::add);
        return siteSettings;
    }

    public Optional<SiteSetting> getSiteSetting(String id){
        return siteSettingRepository.findById(id);
    }

    public void addSiteSetting(SiteSetting ss){
        siteSettingRepository.save(ss);
    }

    public SiteSetting updateSiteSetting(SiteSetting ss){
        Optional<SiteSetting> ssopt = siteSettingRepository.findById(ss.getId());
        SiteSetting siteSetting = ssopt.get();
        siteSetting.setId(ss.getId());
        siteSetting.setThemeName(ss.getThemeName());
        siteSetting.setSmsUrl(ss.getSmsUrl());
        siteSetting.setAdmissionUrl(ss.getAdmissionUrl());
        siteSetting.setHeaderOne(ss.getHeaderOne());
        siteSetting.setHeaderTwo(ss.getHeaderTwo());
        siteSettingRepository.save(siteSetting);
        return siteSetting;
    }

    public void saveSSMainIconImage(SiteSetting ss, MultipartFile imageFile) throws IOException{
        Path currentPath = Paths.get(".");
        Path absolutePath = currentPath.toAbsolutePath();
        String uploadPath = absolutePath + "/src/main/resources/static/uploads/";
        long datetime = System.currentTimeMillis();
        String dt = Long.toString(datetime);
        byte[] bytes =  imageFile.getBytes();
        Path path = Paths.get(uploadPath + dt + imageFile.getOriginalFilename());
        Files.write(path,bytes);
        ss.setMainIconFn(dt + imageFile.getOriginalFilename());
        siteSettingRepository.save(ss);
    }

    public void saveSSMNegativeIconImage(SiteSetting ss, MultipartFile imageFile) throws IOException{
        Path currentPath = Paths.get(".");
        Path absolutePath = currentPath.toAbsolutePath();
        String uploadPath = absolutePath + "/src/main/resources/static/uploads/";
        long datetime = System.currentTimeMillis();
        String dt = Long.toString(datetime);
        byte[] bytes =  imageFile.getBytes();
        Path path = Paths.get(uploadPath + dt + imageFile.getOriginalFilename());
        Files.write(path,bytes);
        ss.setNegativeIconFn(dt + imageFile.getOriginalFilename());
        siteSettingRepository.save(ss);
    }

    public void saveSSMLongeIconImage(SiteSetting ss, MultipartFile imageFile) throws IOException{
        Path currentPath = Paths.get(".");
        Path absolutePath = currentPath.toAbsolutePath();
        String uploadPath = absolutePath + "/src/main/resources/static/uploads/";
        long datetime = System.currentTimeMillis();
        String dt = Long.toString(datetime);
        byte[] bytes = imageFile.getBytes();
        Path path = Paths.get(uploadPath + dt + imageFile.getOriginalFilename());
        Files.write(path,bytes);
        ss.setIconLongFn(dt + imageFile.getOriginalFilename());
        siteSettingRepository.save(ss);
    }

    public void saveSSheadermp4(SiteSetting ss, MultipartFile imageFile) throws IOException{
        Path currentPath = Paths.get(".");
        Path absolutePath = currentPath.toAbsolutePath();
        String uploadPath = absolutePath + "/src/main/resources/static/uploads/";
        long datetime = System.currentTimeMillis();
        String dt = Long.toString(datetime);
        byte[] bytes = imageFile.getBytes();
        Path path = Paths.get(uploadPath + dt + imageFile.getOriginalFilename());
        Files.write(path,bytes);
        ss.setHeadermp4(dt + imageFile.getOriginalFilename());
        siteSettingRepository.save(ss);
    }

    public void deleteSiteSetting(String id){
        siteSettingRepository.deleteById(id);
    }
}
