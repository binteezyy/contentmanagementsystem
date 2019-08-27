package com.ppt.contentmanagementsystem.dao;

import com.ppt.contentmanagementsystem.model.College;
import com.ppt.contentmanagementsystem.repository.CollegeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        if(!collegeRepository.existsById(college.getId()))
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
