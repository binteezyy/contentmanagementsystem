package com.ppt.contentmanagementsystem.mvc;

import com.ppt.contentmanagementsystem.dao.CollegeDAO;
import com.ppt.contentmanagementsystem.dao.DepartmentDAO;
import com.ppt.contentmanagementsystem.model.College;
import com.ppt.contentmanagementsystem.model.Department;
import org.hibernate.validator.constraints.ModCheck;
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
public class DepartmentVC {

    @Autowired
    DepartmentDAO departmentDAO;
    @Autowired
    CollegeDAO collegeDAO;

    @GetMapping("/admin/departments")
    public String departmentsHomePage(Model model){
        List<Department> departments = departmentDAO.getAllDepartments();
        model.addAttribute("departments", departments);

        return "departmentHome";
    }

    @GetMapping("/admin/departments/new")
    public String newDepartmentPage(Model model){
        Department department = new Department();
        List<College> colleges = collegeDAO.getAllColleges();
        model.addAttribute("department", department);
        model.addAttribute("colleges", colleges);

        return "departmentNew";
    }

    @PostMapping("/admin/departments/new")
    public String addDepartmentPage(@ModelAttribute("department") Department department){
        departmentDAO.addDepartment(department);

        return "redirect:/admin/departments";
    }

    @GetMapping("/admin/departments/edit/{id}")
    public String editDepartmentPage(Model model, @PathVariable String id){
//        ModelAndView mav = new ModelAndView("departmentEdit");
        Optional<Department> dopt = departmentDAO.getDepartment(id);
        Department department = dopt.get();
        List<College> colleges = collegeDAO.getAllColleges();
//        mav.addObject("department", department);
        model.addAttribute("department", department);
        model.addAttribute("colleges", colleges);
        return "departmentEdit";
    }

    @PostMapping("/admin/departments/update")
    public String updateDepartmentPage(@ModelAttribute("department") Department department){
        departmentDAO.updateDepartment(department);

        return "redirect:/admin/departments";
    }

    @GetMapping("/admin/departments/delete/{id}")
    public String deleteDepartmentPage(@PathVariable String id){
        departmentDAO.deleteDepartment(id);

        return "redirect:/admin/departments";
    }


}
