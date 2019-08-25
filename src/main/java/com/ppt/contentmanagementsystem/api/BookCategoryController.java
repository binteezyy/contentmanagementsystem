package com.ppt.contentmanagementsystem.api;

import com.ppt.contentmanagementsystem.model.BookCategory;
import com.ppt.contentmanagementsystem.repository.BookCategoryRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
public class BookCategoryController {
    private BookCategoryRepository bookCategoryRepository;

    @GetMapping(path="/all")
    public @ResponseBody
    Iterable<BookCategory> getAllUsers() {
        // This returns a JSON or XML with the users
        return bookCategoryRepository.findAll();
    }
}
