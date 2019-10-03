package com.ppt.contentmanagementsystem.repository;

import com.ppt.contentmanagementsystem.model.Event;
import org.springframework.data.repository.CrudRepository;

public interface EventRepository extends CrudRepository<Event, Long> {
}
