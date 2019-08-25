package com.ppt.contentmanagementsystem.api;

import com.ppt.contentmanagementsystem.dao.TextContentDAO;
import com.ppt.contentmanagementsystem.model.TextContent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
public class TextContentController {

    @Autowired
    private TextContentDAO textContentDAO;

    @GetMapping("/contents")
    public @ResponseBody Iterable<TextContent> getAllTextContent() {
        return textContentDAO.getAllTextContent();
    }

    @PostMapping("/contents")
    public void addTextContent(@Valid @RequestBody TextContent t){
        textContentDAO.addTextContent(t);
    }

    @GetMapping("/contents/{id}")
    public @ResponseBody
    Optional<TextContent> getTextContent(@PathVariable String id){
        return textContentDAO.getTextContent(id);
    }

    @PutMapping("/contents/{id}")
    public @ResponseBody TextContent updateTextContent(@PathVariable String id, @Valid @RequestBody TextContent t){
        return textContentDAO.updateTextContent(id, t);
    }

    @DeleteMapping("/contents/{id}")
    public void deleteTextContent(@PathVariable String id){
        textContentDAO.deleteTextContent(id);
    }

}
