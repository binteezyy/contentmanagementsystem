package com.ppt.contentmanagementsystem.api;

import com.ppt.contentmanagementsystem.dao.SocialLinkDAO;
import com.ppt.contentmanagementsystem.model.SocialLink;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

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
