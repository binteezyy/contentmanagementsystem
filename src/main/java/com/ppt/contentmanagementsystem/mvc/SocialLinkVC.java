package com.ppt.contentmanagementsystem.mvc;

import com.ppt.contentmanagementsystem.dao.SocialLinkDAO;
import com.ppt.contentmanagementsystem.model.SocialLink;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Controller
public class SocialLinkVC {

    @Autowired
    SocialLinkDAO socialLinkDAO;

    @GetMapping("/admin/socials")
    public String socialLinksHomePage(Model model){
        List<SocialLink> socialLinks = socialLinkDAO.getAllSocialLink();
        model.addAttribute("socialLinks", socialLinks);
        model.addAttribute("title", "Social Media Links");

        return "socialHome";
    }

    @GetMapping("/admin/socials/new")
    public String newSocialLinkPage(Model model){
        SocialLink socialLink = new SocialLink();
        model.addAttribute("socialLink", socialLink);

        return "socialNew";
    }

    @PostMapping("/admin/socials/new")
    public String addSocialPage(@ModelAttribute("socialLink") SocialLink socialLink){
        socialLinkDAO.addSocialLink(socialLink);

        return "redirect:/admin/socials";
    }

    @GetMapping("/admin/socials/edit/{id}")
    public String editSocialPage(Model model, @PathVariable Long id){
        Optional<SocialLink> slopt = socialLinkDAO.getSocialLink(id);
        SocialLink socialLink = slopt.get();
        model.addAttribute("socialLink", socialLink);

        return "socialEdit";
    }

    @PostMapping("/admin/socials/update")
    public String updateSocialPage(@ModelAttribute("socialLink") SocialLink socialLink){
        socialLinkDAO.updateSocialLink(socialLink);

        return "redirect:/admin/socials";
    }

    @GetMapping("/admin/socials/imageUpload/{id}")
    public String uploadSocialImagePage(Model model, @PathVariable Long id){
        Optional<SocialLink> slopt = socialLinkDAO.getSocialLink(id);
        SocialLink socialLink = slopt.get();
        model.addAttribute("socialLink", socialLink);
        model.addAttribute("accept", "image/*");

        return "socialImage";
    }

    @PostMapping("/admin/socials/imageUpload")
    public String updateSocialImage(@ModelAttribute("socialLink") SocialLink socialLink, @RequestParam("imageFile")MultipartFile imageFile) throws IOException {
        socialLinkDAO.saveSLImage(socialLink, imageFile);

        return "redirect:/admin/socials";
    }

    @GetMapping("/admin/socials/delete/{id}")
    public String deleteSocialPage(@PathVariable Long id){
        socialLinkDAO.deleteSocialLink(id);

        return "redirect:/admin/employees";
    }
}
