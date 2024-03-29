package com.ppt.contentmanagementsystem.dao;

import com.ppt.contentmanagementsystem.model.Department;
import com.ppt.contentmanagementsystem.model.Employee;
import com.ppt.contentmanagementsystem.repository.DepartmentRepository;
import com.ppt.contentmanagementsystem.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeDAO {

    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    DepartmentRepository departmentRepository;

    public List<Employee> getAllEmployee(String deptId){
        List<Employee> employees = new ArrayList<>();
        employeeRepository.findAllByDepartment(deptId)
                .forEach(employees::add);
        return employees;
    }

    public Optional<Employee> getEmployee(String id){
        return employeeRepository.findById(id);
    }

    public void addEmployee(Employee e, String deptId){
        Optional<Department> dopt = departmentRepository.findById(deptId);
        if (!employeeRepository.existsById(e.getName()))
            e.setDepartment(dopt.get());
            employeeRepository.save(e);
    }

    public Employee updateEmployee(Employee e){
        Optional<Employee> eopt = employeeRepository.findById(e.getName());
        Employee emp = eopt.get();
        emp.setName(e.getName());
        emp.setCredentials(e.getCredentials());
        emp.setDesignation(e.getDesignation());
        employeeRepository.save(emp);
        return emp;
    }

    public void deleteEmployee(String id){
        employeeRepository.deleteById(id);
    }

}