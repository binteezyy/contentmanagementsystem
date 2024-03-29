package com.ppt.contentmanagementsystem.api;

import com.ppt.contentmanagementsystem.dao.DepartmentDAO;
import com.ppt.contentmanagementsystem.dao.EmployeeDAO;
import com.ppt.contentmanagementsystem.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeDAO employeeDAO;
    @Autowired
    private DepartmentDAO departmentDAO;

    @GetMapping("/departments/{deptId}/employees")
    public @ResponseBody Iterable<Employee> getAllEmployee(@PathVariable String deptId){
        return employeeDAO.getAllEmployee(deptId);
    }

    @PostMapping("/departments/{deptId}/employees")
    public void addEmployee(@Valid @RequestBody Employee e, @PathVariable String deptId){
        employeeDAO.addEmployee(e, deptId);
    }

    @GetMapping("/employees/{id}")
    public @ResponseBody
    Optional<Employee> getEmployee(@PathVariable String id){
        return employeeDAO.getEmployee(id);
    }

    @PutMapping("/employees/{id}")
    public @ResponseBody Employee updateEmployee(@Valid @RequestBody Employee e){
        return employeeDAO.updateEmployee(e);
    }

    @DeleteMapping("/employees/{id}")
    public void deleteEmployee(@PathVariable String id){
        employeeDAO.deleteEmployee(id);
    }
}