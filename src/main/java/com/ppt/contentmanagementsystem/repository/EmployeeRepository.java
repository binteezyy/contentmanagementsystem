package com.ppt.contentmanagementsystem.repository;

import com.ppt.contentmanagementsystem.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends CrudRepository<Employee, String> {
    @Query("select emp from Employee emp where emp.department.name= :deptId")
    public List<Employee> findAllByDepartment(String deptId);
}
