package com.ppt.contentmanagementsystem.mvc;

import com.ppt.contentmanagementsystem.dao.SiteInfoDAO;
import com.ppt.contentmanagementsystem.model.SiteInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class SiteInfoVC {

    @Autowired
    SiteInfoDAO siteInfoDAO;

    @GetMapping("/admin/infos")
    public String infoHomePage(Model model){
        List<SiteInfo> infos = siteInfoDAO.getAllSiteInfo();
        model.addAttribute("infos", infos);
        model.addAttribute("title", "Site Infos");

        return "infoHome";
    }

    @GetMapping("/admin/infos/new")
    public String newInfoPage(Model model){
        SiteInfo info = new SiteInfo();
        model.addAttribute("info", info);
        model.addAttribute("title","New Site Information");

        return "infoNew";
    }

    @PostMapping("/admin/infos/new")
    public String addInfoPage(@ModelAttribute("info") SiteInfo info){
        siteInfoDAO.addSiteInfo(info);

        return "redirect:/admin/infos";
    }

    @GetMapping("/admin/infos/edit/{id}")
    public String editInfoPage(Model model, @PathVariable Long id){
        Optional<SiteInfo> siopt = siteInfoDAO.getSiteInfo(id);
        SiteInfo info = siopt.get();
        model.addAttribute("info", info);

        return "infoEdit";
    }

    @PostMapping("/admin/infos/update")
    public String updateInfoPage(@ModelAttribute("info") SiteInfo info){
        siteInfoDAO.updateSiteInfo(info);

        return "redirect:/admin/infos";
    }

    @GetMapping("/admin/infos/delete/{id}")
    public String deleteInfoPage(@PathVariable Long id){
        siteInfoDAO.deleteSiteInfo(id);

        return "redirect:/admin/infos";
    }
}
