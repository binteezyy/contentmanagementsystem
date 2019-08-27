package com.ppt.contentmanagementsystem.api;

import com.ppt.contentmanagementsystem.dao.CollegeDAO;
import com.ppt.contentmanagementsystem.model.College;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class CollegeController {

    @Autowired
    CollegeDAO collegeDAO;

    @GetMapping("/colleges")
    public @ResponseBody
    List<College> getAllColleges(){
        return collegeDAO.getAllColleges();
    }

    @GetMapping("/colleges/{id}")
    public @ResponseBody
    Optional<College> getCollege(@PathVariable String id){
        return collegeDAO.getCollege(id);
    }

    @PostMapping("/colleges")
    public void addCollege(@Valid @RequestBody College college){
        collegeDAO.addCollege(college);
    }

    @PutMapping("/colleges/{id}")
    public @ResponseBody College updateCollege(@Valid @RequestBody College college){
        return collegeDAO.updateCollege(college);
    }

    @DeleteMapping("/colleges/{id}")
    public void deleteCollege(@PathVariable String id){
        collegeDAO.deleteCollege(id);
    }

}
