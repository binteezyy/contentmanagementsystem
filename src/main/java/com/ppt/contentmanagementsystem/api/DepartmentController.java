package com.ppt.contentmanagementsystem.api;

import com.ppt.contentmanagementsystem.dao.DepartmentDAO;
import com.ppt.contentmanagementsystem.model.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentDAO departmentDAO;


    @GetMapping("/colleges/{collegeId}/departments")
    public @ResponseBody Iterable<Department> getAllDepartmentsByCollege(@PathVariable String collegeId){
        return departmentDAO.getAllDepartmentsByCollege(collegeId);
    }

    @PostMapping("/colleges/{collegeId}/departments")
    public void addDepartment(@Valid @RequestBody Department dept, @PathVariable String collegeId){
        departmentDAO.addDepartmentInCollege(dept, collegeId);
    }

    @GetMapping("/departments")
    public @ResponseBody
    List<Department> getAllDepartments(){
        return departmentDAO.getAllDepartments();
    }

    @GetMapping("/departments/{id}")
    public @ResponseBody
    Optional<Department> getDepartment(@PathVariable String id){
        return departmentDAO.getDepartment(id);
    }

//    @PutMapping("/departments/{id}")
//    public @ResponseBody
//    Department updateDepartment(@Valid @RequestBody Department dept){
//        return departmentDAO.updateDepartment(dept);
//    }

//    @DeleteMapping("/departments/{id}")
//    public void deleteDepartment(@PathVariable String id){
//        departmentDAO.deleteDepartment(id);
//    }
}
