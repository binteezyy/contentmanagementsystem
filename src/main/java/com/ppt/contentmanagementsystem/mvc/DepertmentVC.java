package com.ppt.contentmanagementsystem.mvc;

import com.ppt.contentmanagementsystem.dao.DepartmentDAO;
import com.ppt.contentmanagementsystem.model.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
public class DepertmentVC {

    @Autowired
    DepartmentDAO departmentDAO;

    @GetMapping("/admin/departments")
    public String departmentHomePage(Model model){
        List<Department> departments = departmentDAO.getAllDepartments();
        model.addAttribute("departments", departments);

        return "departmentHome";
    }

    @GetMapping("/admin/departments/new")
    public String newDepartmentPage(Model model){
        Department department = new Department();
        model.addAttribute("department", department);

        return "newDepartment";
    }

    @PostMapping("/admin/departments/new")
    public String addDepartmentPage(@ModelAttribute("department") Department department){
        departmentDAO.addDepartment(department);

        return "redirect:/admin/departments";
    }

    @GetMapping("/admin/departments/edit/{id}")
    public ModelAndView editDepartmentPage(@PathVariable String id){
        ModelAndView mav = new ModelAndView("editDepartment");
        Optional<Department> department = departmentDAO.getDepartment(id);
        mav.addObject("department", department);
        return mav;
    }

    @PostMapping("/admin/departments/update")
    public String updateDepartmentPage(@ModelAttribute("department") Department department){
        departmentDAO.updateDepartment(department.getName(), department);

        return "redirect:/admin/departments";
    }

    @GetMapping("/admin/departments/delete/{id}")
    public String deleteDepartmentPage(@PathVariable String id){
        departmentDAO.deleteDepartment(id);

        return "redirect:/admin/departments";
    }
}
