package com.ppt.contentmanagementsystem.repository;

import com.ppt.contentmanagementsystem.model.TextContent;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface TextContentRepository extends CrudRepository<TextContent, String> {
}
