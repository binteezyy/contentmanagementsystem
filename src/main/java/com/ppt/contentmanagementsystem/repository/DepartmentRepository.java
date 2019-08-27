package com.ppt.contentmanagementsystem.repository;

import com.ppt.contentmanagementsystem.model.Department;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DepartmentRepository extends CrudRepository <Department, String>{
    @Query("select dept from Department dept where dept.college.id= :collegeId")
    public List<Department> findAllByCollege(String collegeId);
}
