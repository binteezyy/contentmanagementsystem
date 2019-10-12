package com.ppt.contentmanagementsystem.repository;

import com.ppt.contentmanagementsystem.model.News;
import org.springframework.data.repository.CrudRepository;

public interface NewsRepository extends CrudRepository<News, Long> {
}
