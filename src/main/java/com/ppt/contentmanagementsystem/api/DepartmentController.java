package com.ppt.contentmanagementsystem.api;

import com.ppt.contentmanagementsystem.dao.DepartmentDAO;
import com.ppt.contentmanagementsystem.model.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentDAO departmentDAO;


    @GetMapping("/colleges/{collegeId}/departments")
    public @ResponseBody Iterable<Department> getAllDepartments(@PathVariable String collegeId){
        return departmentDAO.getAllDepartments(collegeId);
    }

    @PostMapping("/colleges/{collegeId}/departments")
    public void addDepartment(@Valid @RequestBody Department dept, @PathVariable String collegeId){
        departmentDAO.addDepartment(dept, collegeId);
    }

    @GetMapping("/departments/{id}")
    public @ResponseBody
    Optional<Department> getDepartment(@PathVariable String id){
        return departmentDAO.getDepartment(id);
    }

    @PutMapping("/departments/{id}")
    public @ResponseBody
    Department updateDepartment(@Valid @RequestBody Department dept){
        return departmentDAO.updateDepartment(dept);
    }

    @DeleteMapping("/departments/{id}")
    public void deleteDepartment(@PathVariable String id){
        departmentDAO.deleteDepartment(id);
    }
}
