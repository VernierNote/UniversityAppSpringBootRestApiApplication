package com.java.springboot.task.controller;

import com.java.springboot.task.dto.FacultyDto;
import com.java.springboot.task.entity.Faculty;
import com.java.springboot.task.entity.Student;
import com.java.springboot.task.mapper.FacultyMapper;
import com.java.springboot.task.mapper.StudentMapper;
import com.java.springboot.task.service.FacultyService;
import com.java.springboot.task.service.StudentService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/rest/faculty")
public class RestFacultyController {

    private final FacultyService facultyService;

    public RestFacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    @GetMapping("list")
    public Page<FacultyDto> showUpdateForm(@RequestParam ( name = "page", defaultValue = "0" ) Integer page,
                                           @RequestParam ( defaultValue = "5" ) Integer pageSize,
                                           @RequestParam ( defaultValue = "id" ) String sortBy,
                                           @RequestParam ( defaultValue = "ASC" ) Sort.Direction order ) {
        return FacultyMapper.MAPPER.mapCollectionToDto(facultyService.list(page, pageSize, sortBy, order));
    }
}
