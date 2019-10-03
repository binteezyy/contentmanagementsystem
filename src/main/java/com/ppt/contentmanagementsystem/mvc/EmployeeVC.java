package com.ppt.contentmanagementsystem.mvc;

import com.ppt.contentmanagementsystem.dao.DepartmentDAO;
import com.ppt.contentmanagementsystem.dao.EmployeeDAO;
import com.ppt.contentmanagementsystem.model.Department;
import com.ppt.contentmanagementsystem.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

@Controller
public class EmployeeVC {

    @Autowired
    EmployeeDAO employeeDAO;
    @Autowired
    DepartmentDAO departmentDAO;

    @GetMapping("/admin/employees")
    public String employeesHomePage(Model model){
        List<Employee> employees = employeeDAO.getAllEmployees();
        model.addAttribute("employees", employees);
        model.addAttribute("title", "Employees");

        return "employeeHome";
    }

    @GetMapping("/admin/employees/new")
    public String newEmployeePage(Model model){
        Employee employee = new Employee();
        List<Department> departments = departmentDAO.getAllDepartments();
        model.addAttribute("employee", employee);
        model.addAttribute("departments", departments);

        return "employeeNew";
    }

    @PostMapping("/admin/employees/new")
    public String addEmployeePage(@ModelAttribute("employee") Employee employee){
        employeeDAO.addEmployee(employee);
        return "redirect:/admin/employees";
    }

    @GetMapping("/admin/employees/edit/{id}")
    public String editEmployeePage(Model model, @PathVariable String id){
        Optional<Employee> eopt = employeeDAO.getEmployee(id);
        Employee employee = eopt.get();
        List<Department> departments = departmentDAO.getAllDepartments();
        model.addAttribute("employee", employee);
        model.addAttribute("departments", departments);
        model.addAttribute("title", "Employee Edit");

        return "employeeEdit";
    }

    @GetMapping("/admin/employees/imageUpload/{id}")
    public String uploadEmployeeImagePage(Model model, @PathVariable String id){
        Optional<Employee> eopt = employeeDAO.getEmployee(id);
        Employee employee = eopt.get();
        model.addAttribute("employee", employee);
        model.addAttribute("title", "Employee Image");

        return "employeeImage";
    }

    @PostMapping("/admin/employees/imageUpload")
    public String updateEmployeeImage(@ModelAttribute("employee") Employee employee, @RequestParam("imageFile") MultipartFile imageFile) throws IOException{
        employeeDAO.saveEmployeeImage(employee, imageFile);

        return "redirect:/admin/employees";
    }

    @PostMapping("/admin/employees/update")
    public String updateEmployeePage(@ModelAttribute("employee") Employee employee){
        employeeDAO.updateEmployee(employee);

        return "redirect:/admin/employees";
    }

    @GetMapping("/admin/employees/delete/{id}")
    public String deleteEmployeePage(@PathVariable String id){
        employeeDAO.deleteEmployee(id);

        return "redirect:/admin/employees";
    }
}
