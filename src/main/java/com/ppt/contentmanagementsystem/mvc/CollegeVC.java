package com.ppt.contentmanagementsystem.mvc;

import com.ppt.contentmanagementsystem.dao.CollegeDAO;
import com.ppt.contentmanagementsystem.model.College;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Controller
public class CollegeVC {

    @Autowired
    CollegeDAO collegeDAO;

    @GetMapping("/")
    public String homePage(Model model) {
        model.addAttribute("title", "Dashboard");
        return "home";
    }
    
    @GetMapping("/home")
    public String homePages(Model model) {
        model.addAttribute("title", "Dashboard");
        return "home";
    }

    @GetMapping("/admin/colleges")
    public String collegesHomePage(Model model){
        List<College> colleges = collegeDAO.getAllColleges();
        model.addAttribute("colleges", colleges);
        model.addAttribute("title", "Colleges");

        return "collegeHome";
    }

    @GetMapping("/admin/colleges/new")
    public String newCollegePage(Model model){
        College college = new College();
        model.addAttribute("college", college);
        model.addAttribute("title", "Add New College");

        return "collegeNew";
    }

    @PostMapping("/admin/colleges/new")
    public String addCollegePage(@ModelAttribute("college") College college){
        collegeDAO.addCollege(college);

        return "redirect:/admin/colleges";
    }

    @GetMapping("/admin/colleges/edit/{id}")
    public String editCollege(Model model, @PathVariable String id){
        Optional<College> copt = collegeDAO.getCollege(id);
        College college = copt.get();
        model.addAttribute("college", college);

        return "collegeEdit";
    }

    @PostMapping("/admin/colleges/update")
    public String updateCollegePage(@ModelAttribute("college") College college){
        collegeDAO.updateCollege(college);

        return "redirect:/admin/colleges";
    }

    @GetMapping("/admin/colleges/imageUpload/{id}")
    public String uploadCollegeImagePage(Model model, @PathVariable String id){
        Optional<College> copt = collegeDAO.getCollege(id);
        College college = copt.get();
        model.addAttribute("college", college);
        model.addAttribute("accept", "image/*");

        return "collegeImage";
    }

    @PostMapping("/admin/colleges/imageUpload")
    public String updateDepartmentImage(@ModelAttribute("college") College college, @RequestParam("imageFile")MultipartFile imageFile) throws IOException {
        collegeDAO.saveCollegeImage(college, imageFile);

        return"redirect:/admin/colleges";
    }

    @GetMapping("/admin/colleges/delete/{id}")
    public String deleteCollegePage(@PathVariable String id){
        collegeDAO.deleteCollege(id);

        return "redirect:/admin/colleges";
    }
}
