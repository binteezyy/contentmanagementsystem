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


    @GetMapping("/departments")
    public @ResponseBody Iterable<Department> getAllDepartments(){
        return departmentDAO.getAllDepartments();
    }

    @PostMapping("/departments")
    public void addDepartment(@Valid @RequestBody Department dept){
        departmentDAO.addDepartment(dept);
    }

    @GetMapping("/departments/{id}")
    public @ResponseBody
    Optional<Department> getDepartment(@PathVariable String id){
        return departmentDAO.getDepartment(id);
    }

    @PutMapping("/departments/{id}")
    public @ResponseBody
    Department updateDepartment(@PathVariable String id, @Valid @RequestBody Department dept){
        return departmentDAO.updateDepartment(id, dept);
    }

    @DeleteMapping("/departments/{id}")
    public void deleteDepartment(@PathVariable String id){
        departmentDAO.deleteDepartment(id);
    }
}
