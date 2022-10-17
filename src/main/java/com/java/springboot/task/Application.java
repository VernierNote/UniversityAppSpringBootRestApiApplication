package com.java.springboot.task;

import com.java.springboot.task.entity.Faculty;
import com.java.springboot.task.entity.Student;
import com.java.springboot.task.repository.FacultyRepository;
import com.java.springboot.task.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    FacultyRepository facultyRepository;

    @Autowired
    StudentRepository studentRepository;


    private List<Faculty> faculties = new ArrayList<>();

    private List<Student> students = new ArrayList<>();

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        faculties.add(facultyRepository.save(new Faculty("Мехмат")));
        faculties.add(facultyRepository.save(new Faculty("Радиофак")));
        faculties.add(facultyRepository.save(new Faculty("Физфак")));
        faculties.add(facultyRepository.save(new Faculty("Литфак")));

        students.add(studentRepository.save(new Student("Сидоров Иван Инокентьевич", "sidorovia@mail.ru", 19, "sayyourmagicword", faculties.get(0))));
        students.add(studentRepository.save(new Student("Петров Себастьян Вагитович", "petrovsv@gmail.com", 18, "onemoretime", faculties.get(1))));
        students.add(studentRepository.save(new Student("Васильева Майя Оганесовна", "vasilievamo@rambler.ru", 20, "justincaseof", faculties.get(2))));
        students.add(studentRepository.save(new Student("Рогов Кирилл Николаевич", "rogovkn@wonnacry.net", 21, "easyroll", faculties.get(3))));
        students.add(studentRepository.save(new Student("Водопьянов Сергей Николаевич", "vodopyanovsn@worldwide.net", 23, "screamy", faculties.get(1))));
        students.add(studentRepository.save(new Student("Карапетян Мефодий Фарсукович", "karapet@rambler.ru", 17, "iceworld", faculties.get(2))));
        students.add(studentRepository.save(new Student("Батистута Габриэль Эрнестович", "batistutagabriel@gmail.com", 30, "qwerty", faculties.get(2))));

    }
}