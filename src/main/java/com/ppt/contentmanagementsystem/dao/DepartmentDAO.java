package com.ppt.contentmanagementsystem.dao;

import com.ppt.contentmanagementsystem.model.Department;
import com.ppt.contentmanagementsystem.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DepartmentDAO {

    @Autowired
    DepartmentRepository departmentRepository;

    public List<Department> getAllDepartments(){
        List<Department> departments= new ArrayList<>();
        departmentRepository.findAll()
                .forEach(departments::add);
        return departments;
    }

    public Optional<Department> getDepartment(String id){
        return departmentRepository.findById(id);
    }

    public void addDepartment(Department dept){
        if(!departmentRepository.existsById(dept.getName()))
            departmentRepository.save(dept);
    }

    public Department updateDepartment(String id, Department dept){
        Optional<Department> dopt = departmentRepository.findById(id);
        Department dupt = dopt.get();
        dupt.setName(dept.getName());
        dupt.setDescription(dept.getDescription());
        departmentRepository.save(dupt);
        return dupt;
    }

    public void deleteDepartment(String id){
        departmentRepository.deleteById(id);
    }
}
