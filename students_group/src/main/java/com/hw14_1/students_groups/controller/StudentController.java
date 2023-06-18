package com.hw14_1.students_groups.controller;

import com.hw14_1.students_groups.dto.AddStudentDto;
import com.hw14_1.students_groups.dto.GroupByIdDto;
import com.hw14_1.students_groups.entity.Student;
import com.hw14_1.students_groups.service.StudentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
@Slf4j
public class StudentController {

    private StudentService studentService;

    @PostMapping()
    public void addStudent(@RequestBody AddStudentDto addStudentDto) {
        log.debug("Entrance in addStudent method in students controller");
        studentService.addStudent(addStudentDto);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Integer id) {
        log.debug("Entrance in deleteStudent method in students controller");
                studentService.deleteStudent(id);

    }


}
