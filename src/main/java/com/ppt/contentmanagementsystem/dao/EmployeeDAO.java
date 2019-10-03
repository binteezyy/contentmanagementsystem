package com.ppt.contentmanagementsystem.dao;

import com.ppt.contentmanagementsystem.model.Department;
import com.ppt.contentmanagementsystem.model.Employee;
import com.ppt.contentmanagementsystem.repository.DepartmentRepository;
import com.ppt.contentmanagementsystem.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeDAO {

    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    DepartmentRepository departmentRepository;

    public List<Employee> getAllEmployeesByDepartment(String deptId){
        List<Employee> employees = new ArrayList<>();
        employeeRepository.findAllByDepartment(deptId)
                .forEach(employees::add);
        return employees;
    }

    public List<Employee> getAllEmployees(){
        List<Employee> employees = new ArrayList<>();
        employeeRepository.findAll()
                .forEach(employees::add);
        return employees;
    }

    public Optional<Employee> getEmployee(String id){
        return employeeRepository.findById(id);
    }

    public void addEmployeeInDepartment(Employee e, String deptId){
        Optional<Department> dopt = departmentRepository.findById(deptId);
        if (!employeeRepository.existsById(e.getName()))
            e.setDepartment(dopt.get());
            employeeRepository.save(e);
    }

    public void addEmployee(Employee e){
        employeeRepository.save(e);
    }

    public void saveEmployeeImage(Employee emp, MultipartFile imageFile) throws  IOException {
        Path currentPath = Paths.get(".");
        Path absolutePath = currentPath.toAbsolutePath();
        String uploadPath = absolutePath + "/src/main/resources/static/uploads/";
        long datetime = System.currentTimeMillis();
        String dt = Long.toString(datetime);
        byte[] bytes =  imageFile.getBytes();
        Path path = Paths.get(uploadPath + dt + imageFile.getOriginalFilename());
        Files.write(path,bytes);
        emp.setImage_fn(dt + imageFile.getOriginalFilename());
        employeeRepository.save(emp);
    }

    public Employee updateEmployee(Employee e, Department dept){
        Optional<Employee> eopt = employeeRepository.findById(e.getName());
        Employee emp = eopt.get();
        emp.setName(e.getName());
        emp.setCredentials(e.getCredentials());
        emp.setDesignation(e.getDesignation());
        emp.setDepartment(dept);
        employeeRepository.save(emp);
        return emp;
    }

    public void deleteEmployee(String id){
        employeeRepository.deleteById(id);
    }

}