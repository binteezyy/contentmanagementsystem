package com.ppt.contentmanagementsystem.dao;

import com.ppt.contentmanagementsystem.model.TextContent;
import com.ppt.contentmanagementsystem.repository.TextContentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TextContentDAO {
    @Autowired
    private TextContentRepository textContentRepository;

    public List<TextContent> getAllTextContent(){
        // return all text content
        List<TextContent> textContents = new ArrayList<>();
        textContentRepository.findAll()
                .forEach(textContents::add);
        return textContents;
    }

    public Optional<TextContent> getTextContent(String id){
        return textContentRepository.findById(id);
    }

    public void addTextContent(TextContent t){
        if(!textContentRepository.existsById((t.getCategory())))
            textContentRepository.save(t);
    }

    public TextContent updateTextContent(String id, TextContent t){
        Optional<TextContent> tcopt = textContentRepository.findById(id);
        TextContent tc = tcopt.get();
        tc.setDescription(t.getDescription());
        tc.setCategory(t.getCategory());
        textContentRepository.save(tc);
        return tc;
    }

    public void deleteTextContent(String id) { textContentRepository.deleteById(id);}

}
