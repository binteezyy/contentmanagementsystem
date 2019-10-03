package com.ppt.contentmanagementsystem.api;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.MediaTypeFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.MalformedURLException;

@RestController
public class ImageController {

    @RequestMapping(value="/images/{id}", method = RequestMethod.GET, produces = MediaType.IMAGE_JPEG_VALUE)
    public void getImage(HttpServletResponse response, @PathVariable String id) throws IOException {

        var imageFile = new ClassPathResource("static/uploads/" + id);
        response.setContentType(MediaType.IMAGE_JPEG_VALUE);
        StreamUtils.copy(imageFile.getInputStream(), response.getOutputStream());
    }

    @GetMapping("/videos/{id}")
    public ResponseEntity<UrlResource>  getFullVideo(@PathVariable String id) throws MalformedURLException {
        var video = new UrlResource("static/uploads/" + id);
        return ResponseEntity.status(HttpStatus.PARTIAL_CONTENT)
                .contentType(MediaTypeFactory
                        .getMediaType(video)
                        .orElse(MediaType.APPLICATION_OCTET_STREAM))
                .body(video);
    }
}
