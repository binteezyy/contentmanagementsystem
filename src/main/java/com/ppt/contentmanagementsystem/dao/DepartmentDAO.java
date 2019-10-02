package com.ppt.contentmanagementsystem.dao;

import com.ppt.contentmanagementsystem.model.College;
import com.ppt.contentmanagementsystem.model.Department;
import com.ppt.contentmanagementsystem.repository.CollegeRepository;
import com.ppt.contentmanagementsystem.repository.DepartmentRepository;
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
public class DepartmentDAO {

    @Autowired
    DepartmentRepository departmentRepository;
    @Autowired
    CollegeRepository collegeRepository;

    public List<Department> getAllDepartmentsByCollege(String collegeId){
        List<Department> departments= new ArrayList<>();
        departmentRepository.findAllByCollege(collegeId)
                .forEach(departments::add);
        return departments;
    }

    public List<Department> getAllDepartments(){
        List<Department> departments = new ArrayList<>();
        departmentRepository.findAll()
                .forEach(departments::add);
        return departments;
    }

    public Optional<Department> getDepartment(String id){
        return departmentRepository.findById(id);
    }

    public void addDepartmentInCollege(Department dept, String collegeId){
        Optional<College> copt = collegeRepository.findById(collegeId);
        if(!departmentRepository.existsById(dept.getName())){
            dept.setCollege(copt.get());
            departmentRepository.save(dept);
        }
    }

    public void addDepartment(Department dept){
        departmentRepository.save(dept);
    }

    public void saveDepartmentImage(Department dept, MultipartFile imageFile) throws IOException {
        Path currentPath = Paths.get(".");
        Path absolutePath = currentPath.toAbsolutePath();
        String uploadPath = absolutePath + "/src/main/resources/static/uploads/";
        long datetime = System.currentTimeMillis();
        String dt = Long.toString(datetime);
        byte[] bytes =  imageFile.getBytes();
        Path path = Paths.get(uploadPath + dt + imageFile.getOriginalFilename());
        Files.write(path,bytes);
        dept.setImage_fn(dt + imageFile.getOriginalFilename());
        departmentRepository.save(dept);
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
