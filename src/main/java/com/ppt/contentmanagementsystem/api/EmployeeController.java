package com.ppt.contentmanagementsystem.api;

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

    @GetMapping("/employees")
    public @ResponseBody Iterable<Employee> getAllEmployee(){
        return employeeDAO.getAllEmployee();
    }

    @PostMapping("/employees")
    public void addEmployee(@Valid @RequestBody Employee e){
        employeeDAO.addEmployee(e);
    }

    @GetMapping("/employees/{id}")
    public @ResponseBody
    Optional<Employee> getEmployee(@PathVariable String id){
        return employeeDAO.getEmployee(id);
    }

    @PutMapping("/employees/{id}")
    public @ResponseBody Employee updateEmployee(@PathVariable String id, @Valid @RequestBody Employee e){
        return employeeDAO.updateEmployee(id, e);
    }

    @DeleteMapping("/employees/{id}")
    public void deleteEmployee(@PathVariable String id){
        employeeDAO.deleteEmployee(id);
    }
}