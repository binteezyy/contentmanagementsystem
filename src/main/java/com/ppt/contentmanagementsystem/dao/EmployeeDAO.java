package com.ppt.contentmanagementsystem.dao;

import com.ppt.contentmanagementsystem.model.Employee;
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

    public List<Employee> getAllEmployee(){
        List<Employee> employees = new ArrayList<>();
        employeeRepository.findAll()
                .forEach(employees::add);
        return employees;
    }

    public Optional<Employee> getEmployee(String id){
        return employeeRepository.findById(id);
    }

    public void addEmployee(Employee e){
        if (!employeeRepository.existsById(e.getName()))
            employeeRepository.save(e);
    }

    public Employee updateEmployee(String id, Employee e){
        Optional<Employee> eopt = employeeRepository.findById(id);
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