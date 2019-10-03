package com.ppt.contentmanagementsystem;

import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public interface WebConfigInterface extends WebMvcConfigurer {
    void addCorsMapping(CorsRegistry registry);
}
