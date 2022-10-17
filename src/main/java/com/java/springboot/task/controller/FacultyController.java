package com.java.springboot.task.controller;

import com.java.springboot.task.entity.Faculty;
import com.java.springboot.task.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/faculties/")
public class FacultyController {

    private static final String FACULTY = "faculty";
    private static final String FACULTIES = "faculties";

    private final FacultyService facultyService;

    @Autowired
    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    @GetMapping("list")
    public String showUpdateForm(Model model) {
        model.addAttribute(FACULTY, new Faculty());
        model.addAttribute(FACULTY, facultyService.list());
        return FACULTIES;
    }

    @PostMapping("add")
    public String addFaculty(@Valid Faculty faculty, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute(FACULTY, faculty);
            model.addAttribute(FACULTY, facultyService.list());
            return FACULTIES;
        } else {
            if (facultyService.findByName(faculty.getName()).isEmpty()) {
                facultyService.create(faculty);
            } else {
                String msg = String.format("Faculty with name %s already exists", faculty.getName());
                result.addError(new FieldError(FACULTY, "name", faculty.getName(), false, null, null, msg));
                model.addAttribute(FACULTY, faculty);
                model.addAttribute(FACULTIES, facultyService.list());
                return FACULTIES;
            }
        }


        return "redirect:/faculties/list";
    }

    @GetMapping("delete/{id}")
    public String deleteFaculty(@PathVariable("id") Long id, Model model) {
        facultyService.delete(id);
        model.addAttribute(FACULTIES, facultyService.list());
        return "redirect:/faculties/list";
    }
}
