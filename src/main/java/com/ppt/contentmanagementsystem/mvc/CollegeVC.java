package com.ppt.contentmanagementsystem.mvc;

import com.ppt.contentmanagementsystem.dao.CollegeDAO;
import com.ppt.contentmanagementsystem.model.College;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
public class CollegeVC {

    @Autowired
    CollegeDAO collegeDAO;

    @GetMapping("/admin/colleges")
    public String collegesHomePage(Model model){
        List<College> colleges = collegeDAO.getAllColleges();
        model.addAttribute("colleges", colleges);

        return "collegeHome";
    }

    @GetMapping("/admin/colleges/new")
    public String newCollegePage(Model model){
        College college = new College();
        model.addAttribute("college", college);

        return "collegeNew";
    }

    @PostMapping("/admin/colleges/new")
    public String addCollegePage(@ModelAttribute("college") College college){
        collegeDAO.addCollege(college);

        return "redirect:/admin/colleges";
    }

    @GetMapping("/admin/colleges/edit/{id}")
    public ModelAndView editCollegePage(@PathVariable String id){
        ModelAndView mav = new ModelAndView("collegeEdit");
        Optional<College> college = collegeDAO.getCollege(id);
        mav.addObject("college", college);

        return mav;
    }

    @PostMapping("/admin/colleges/update")
    public String updateCollegePage(@ModelAttribute("college") College college){
        collegeDAO.updateCollege(college);

        return "redirect:/admin/colleges";
    }

    @GetMapping("/admin/colleges/delete/{id}")
    public String deleteCollegePage(@PathVariable String id){
        collegeDAO.deleteCollege(id);

        return "redirect:/admin/colleges";
    }
}
