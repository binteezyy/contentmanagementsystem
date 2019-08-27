package com.ppt.contentmanagementsystem.dao;

import com.ppt.contentmanagementsystem.model.College;
import com.ppt.contentmanagementsystem.model.Department;
import com.ppt.contentmanagementsystem.repository.CollegeRepository;
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
    @Autowired
    CollegeRepository collegeRepository;

    public List<Department> getAllDepartments(String collegeId){
        List<Department> departments= new ArrayList<>();
        departmentRepository.findAllByCollege(collegeId)
                .forEach(departments::add);
        return departments;
    }

    public Optional<Department> getDepartment(String id){
        return departmentRepository.findById(id);
    }

    public void addDepartment(Department dept, String collegeId){
        Optional<College> copt = collegeRepository.findById(collegeId);
        if(!departmentRepository.existsById(dept.getName())){
            dept.setCollege(copt.get());
            departmentRepository.save(dept);
        }
    }

    public Department updateDepartment(Department dept){
        Optional<Department> dopt = departmentRepository.findById(dept.getName());
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
