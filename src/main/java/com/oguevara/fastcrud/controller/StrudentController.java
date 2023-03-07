package com.oguevara.fastcrud.controller;


import com.oguevara.fastcrud.entity.Student;
import com.oguevara.fastcrud.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/v1/student")
public class StrudentController {

    @Autowired
    private StudentService strudentService;

    @GetMapping("/find")
    public List<Student> getAllStudents() {
        return strudentService.getAllStudents();
    }

    @GetMapping("/find/{id}")
    public Optional<Student> getStudent(@PathVariable("id") Long id) {
        return strudentService.getStudent(id);
    }

    @PostMapping ("/save")
    public Student saveStudent(@RequestBody Student student) {
        strudentService.saveOrUpdateStudent(student);
        return student;
    }

    @DeleteMapping("/delete/{id}")
    public void deleteStudent(@PathVariable("id") Long id) {
        strudentService.deleteStudent(id);
    }

}
