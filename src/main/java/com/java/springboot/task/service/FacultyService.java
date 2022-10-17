package com.java.springboot.task.service;

import com.java.springboot.task.entity.Faculty;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

public interface FacultyService {
    Optional<Faculty> findById(Long id);

    List<Faculty> list();

    Page<Faculty> list(Integer from, Integer pageSize, String sortBy, Sort.Direction ordering);

    List<Faculty> findByName(String name);

    Faculty create(Faculty faculty);

    Faculty update(Faculty faculty);

    void delete(Long id);
}
