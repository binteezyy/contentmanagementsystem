package com.ppt.contentmanagementsystem.api;

import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
public class ImageController {

    @RequestMapping(value="/images/{id}", method = RequestMethod.GET, produces = MediaType.IMAGE_JPEG_VALUE)
    public void getImage(HttpServletResponse response, @PathVariable String id) throws IOException {

        var imageFile = new ClassPathResource("static/uploads/" + id);
        response.setContentType(MediaType.IMAGE_JPEG_VALUE);
        StreamUtils.copy(imageFile.getInputStream(), response.getOutputStream());
    }

}
