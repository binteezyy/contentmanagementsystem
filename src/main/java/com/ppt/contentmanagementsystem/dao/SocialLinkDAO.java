package com.ppt.contentmanagementsystem.dao;

import com.ppt.contentmanagementsystem.model.SiteSetting;
import com.ppt.contentmanagementsystem.model.SocialLink;
import com.ppt.contentmanagementsystem.repository.SocialLinkRepository;
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
public class SocialLinkDAO {

    @Autowired
    SocialLinkRepository socialLinkRepository;

    public List<SocialLink> getAllSocialLink(){
        List<SocialLink> socialLinks = new ArrayList<>();
        socialLinkRepository.findAll()
                .forEach(socialLinks::add);
        return socialLinks;
    }

    public Optional<SocialLink> getSocialLink(Long id){
        return socialLinkRepository.findById(id);
    }

    public void addSocialLink(SocialLink socialLink){
        socialLinkRepository.save(socialLink);
    }

    public SocialLink updateSocialLink(SocialLink sl){
        Optional<SocialLink> slopt = socialLinkRepository.findById(sl.getId());
        SocialLink socialLink = slopt.get();
        socialLink.setId(sl.getId());
        socialLink.setName(sl.getName());
        socialLink.setUrl(sl.getUrl());
        socialLinkRepository.save(socialLink);
        return socialLink;
    }

    public void saveSLImage(SocialLink sl, MultipartFile imageFile) throws IOException {
        Path currentPath = Paths.get(".");
        Path absolutePath = currentPath.toAbsolutePath();
        String uploadPath = absolutePath + "/src/main/resources/static/uploads/";
        long datetime = System.currentTimeMillis();
        String dt = Long.toString(datetime);
        byte[] bytes =  imageFile.getBytes();
        Path path = Paths.get(uploadPath + dt + imageFile.getOriginalFilename());
        Files.write(path,bytes);
        sl.setImage_fn(dt + imageFile.getOriginalFilename());
        socialLinkRepository.save(sl);
    }

    public void deleteSocialLink(Long id){
        socialLinkRepository.deleteById(id);
    }
}
