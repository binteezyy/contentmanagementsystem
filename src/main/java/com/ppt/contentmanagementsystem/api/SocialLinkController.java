package com.ppt.contentmanagementsystem.api;

import com.ppt.contentmanagementsystem.dao.SocialLinkDAO;
import com.ppt.contentmanagementsystem.model.SocialLink;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:80", maxAge = 3600)
@RestController
public class SocialLinkController {

    @Autowired
    private SocialLinkDAO socialLinkDAO;

    @GetMapping("/socials")
    public @ResponseBody
    List<SocialLink> getAllSocialLinks(){
        return socialLinkDAO.getAllSocialLink();
    }

    @GetMapping("/socials/{id}")
    public @ResponseBody
    Optional<SocialLink> getSocialLink(@PathVariable Long id){
        return socialLinkDAO.getSocialLink(id);
    }
}
