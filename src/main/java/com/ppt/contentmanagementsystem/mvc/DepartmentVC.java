package com.ppt.contentmanagementsystem.mvc;

import com.ppt.contentmanagementsystem.dao.CollegeDAO;
import com.ppt.contentmanagementsystem.dao.DepartmentDAO;
import com.ppt.contentmanagementsystem.model.College;
import com.ppt.contentmanagementsystem.model.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

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

        return "newDepartment";
    }

    @PostMapping("/admin/departments/new")
    public String addDepartmentPage(@ModelAttribute("department") Department department){
        departmentDAO.addDepartment(department);

        return "redirect:/admin/departments";
    }

}
