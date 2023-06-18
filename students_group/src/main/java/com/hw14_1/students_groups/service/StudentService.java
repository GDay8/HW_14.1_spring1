package com.hw14_1.students_groups.service;

import com.hw14_1.students_groups.dto.AddStudentDto;
import com.hw14_1.students_groups.entity.Student;
import lombok.extern.slf4j.Slf4j;

public interface StudentService {

    public void addStudent(AddStudentDto addStudentDto);

    public void deleteStudent(Integer id);

}
