package com.ppt.contentmanagementsystem.mvc;

import com.ppt.contentmanagementsystem.dao.SiteSettingDAO;
import com.ppt.contentmanagementsystem.model.SiteSetting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Controller
public class SiteSettingVC {

    @Autowired
    SiteSettingDAO siteSettingDAO;

    @GetMapping("/admin/settings")
    public String settingsHomePage(Model model){
        List<SiteSetting> settings = siteSettingDAO.getAllSiteSetting();
        model.addAttribute("settings", settings);
        model.addAttribute("title", "Site Settings");
        return "settingHome";
    }

    @GetMapping("/admin/settings/new")
    public String newSettingsPage(Model model){
        SiteSetting ss = new SiteSetting();
        model.addAttribute("setting", ss);

        return "settingNew";
    }

    @PostMapping("/admin/settings/new")
    public String addSettingsPage(@ModelAttribute("setting") SiteSetting ss){
        siteSettingDAO.addSiteSetting(ss);

        return "redirect:/admin/settings";
    }

    @GetMapping("/admin/settings/edit/{id}")
    public String editSettingsPage(Model model, @PathVariable String id){
        Optional<SiteSetting> ssopt = siteSettingDAO.getSiteSetting(id);
        SiteSetting setting = ssopt.get();
        model.addAttribute("setting", setting);

        return "settingEdit";
    }

    @PostMapping("/admin/settings/update")
    public String updateSettingsPage(@ModelAttribute("setting") SiteSetting ss){
        siteSettingDAO.updateSiteSetting(ss);

        return "redirect:/admin/settings";
    }

    @GetMapping("/admin/settings/mainIconUpload/{id}")
    public String mainIconUploadPage(Model model, @PathVariable String id){
        Optional<SiteSetting> ssopt = siteSettingDAO.getSiteSetting(id);
        SiteSetting setting = ssopt.get();
        model.addAttribute("setting", setting);
        model.addAttribute("title", "Main Icon Image");
        model.addAttribute("path", "mainIconUpload");
        model.addAttribute("accept", "image/*");

        return "settingImage";
    }

    @PostMapping("/admin/settings/mainIconUpload")
    public String mainIconSave(@ModelAttribute("setting") SiteSetting setting, @RequestParam("imageFile")MultipartFile imageFile) throws IOException {
        siteSettingDAO.saveSSMainIconImage(setting, imageFile);

        return "redirect:/admin/settings";
    }

    @GetMapping("/admin/settings/negativeIconUpload/{id}")
    public String negativeIconUploadPage(Model model, @PathVariable String id){
        Optional<SiteSetting> ssopt = siteSettingDAO.getSiteSetting(id);
        SiteSetting setting = ssopt.get();
        model.addAttribute("setting", setting);
        model.addAttribute("title", "Negative Icon Image");
        model.addAttribute("path", "negativeIconUpload");
        model.addAttribute("accept", "image/*");

        return "settingImage";
    }

    @PostMapping("/admin/settings/negativeIconUpload")
    public String negativeIconSave(@ModelAttribute("setting") SiteSetting setting, @RequestParam("imageFile")MultipartFile imageFile) throws IOException {
        siteSettingDAO.saveSSMNegativeIconImage(setting, imageFile);

        return "redirect:/admin/settings";
    }

    @GetMapping("/admin/settings/longIconUpload/{id}")
    public String LongIconUploadPage(Model model, @PathVariable String id){
        Optional<SiteSetting> ssopt = siteSettingDAO.getSiteSetting(id);
        SiteSetting setting = ssopt.get();
        model.addAttribute("setting", setting);
        model.addAttribute("title", "Long Icon Image");
        model.addAttribute("path", "longIconUpload");
        model.addAttribute("accept", "image/*");

        return "settingImage";
    }

    @PostMapping("/admin/settings/longIconUpload")
    public String longIconSave(@ModelAttribute("setting") SiteSetting setting, @RequestParam("imageFile")MultipartFile imageFile) throws IOException {
        siteSettingDAO.saveSSMLongeIconImage(setting, imageFile);

        return "redirect:/admin/settings";
    }

    @GetMapping("/admin/settings/longIconUpload/{id}")
    public String Headermp4UploadPage(Model model, @PathVariable String id){
        Optional<SiteSetting> ssopt = siteSettingDAO.getSiteSetting(id);
        SiteSetting setting = ssopt.get();
        model.addAttribute("setting", setting);
        model.addAttribute("title", "Header mp4");
        model.addAttribute("path", "headermp4Upload");
        model.addAttribute("accept", "video/*");

        return "settingImage";
    }

    @PostMapping("/admin/settings/headermp4Upload")
    public String headermp4Save(@ModelAttribute("setting") SiteSetting setting, @RequestParam("imageFile")MultipartFile imageFile) throws IOException {
        siteSettingDAO.saveSSheadermp4(setting, imageFile);

        return "redirect:/admin/settings";
    }

    @GetMapping("/admin/settings/delete/{id}")
    public String deleteSettingsPage(@PathVariable String id){
        siteSettingDAO.deleteSiteSetting(id);

        return "redirect:/admin/settings";
    }
}
