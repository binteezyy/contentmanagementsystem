package com.ppt.contentmanagementsystem.dao;

import com.ppt.contentmanagementsystem.model.College;
import com.ppt.contentmanagementsystem.model.Department;
import com.ppt.contentmanagementsystem.repository.CollegeRepository;
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
public class CollegeDAO {

    @Autowired
    CollegeRepository collegeRepository;

    public List<College> getAllColleges(){
        List<College> colleges = new ArrayList<>();
        collegeRepository.findAll()
                .forEach(colleges::add);
        return colleges;
    }

    public Optional<College> getCollege(String id){
        return collegeRepository.findById(id);
    }

    public void addCollege(College college){
            collegeRepository.save(college);
    }

    public void saveCollegeImage(College college, MultipartFile imageFile) throws IOException {
        Path currentPath = Paths.get(".");
        Path absolutePath = currentPath.toAbsolutePath();
        String uploadPath = absolutePath + "/src/main/resources/static/uploads/";
        long datetime = System.currentTimeMillis();
        String dt = Long.toString(datetime);
        byte[] bytes =  imageFile.getBytes();
        Path path = Paths.get(uploadPath + dt + imageFile.getOriginalFilename());
        Files.write(path,bytes);
        college.setImage_fn(dt + imageFile.getOriginalFilename());
        collegeRepository.save(college);
    }

    public College updateCollege(College college){
        Optional<College> copt = collegeRepository.findById(college.getId());
        College cupdate = copt.get();
        cupdate.setName(college.getName());
        collegeRepository.save(cupdate);
        return cupdate;
    }

    public void deleteCollege(String id){
        collegeRepository.deleteById(id);
    }

}
