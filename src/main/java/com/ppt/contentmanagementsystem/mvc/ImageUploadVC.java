package com.ppt.contentmanagementsystem.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class ImageUploadVC {
    private String current_dir = System.getProperty("user.dir");

    @GetMapping("/x")
    public String uploading() {
        return "uploading";
    }

}
