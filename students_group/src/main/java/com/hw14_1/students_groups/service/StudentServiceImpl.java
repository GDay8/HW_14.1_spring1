package com.hw14_1.students_groups.service;

import com.hw14_1.students_groups.dto.AddGroupRequestDto;
import com.hw14_1.students_groups.dto.AddStudentDto;
import com.hw14_1.students_groups.entity.Group;
import com.hw14_1.students_groups.entity.Student;
import com.hw14_1.students_groups.repository.GroupRepository;
import com.hw14_1.students_groups.repository.StudentRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.auditing.CurrentDateTimeProvider;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Slf4j
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final GroupRepository groupRepository;

    @Override
//    @Transactional
    public void addStudent(AddStudentDto addStudentDto) {
        log.debug("Entrance in addStudent method in Student service implementation");
        Student student = new Student();
        student.setName(addStudentDto.getName());
        student.setEntranceDate(LocalDateTime.now());
        student.setGroup(groupRepository.findById(addStudentDto.getGroup_id())
                .orElseThrow(() -> {
                    throw new IllegalStateException("can't find group for student");
                }));
        log.debug("Student name "+student.getName());
        log.debug("Student entrance date"+String.valueOf(student.getEntranceDate()));
        studentRepository.save(student);
        log.info("Student was added.");
    }

    @Override
//    @Transactional
    public void deleteStudent(Integer id) {
        log.debug("Entrance in deleteStudent method in Student service implementation for studet with id "+id);
        studentRepository.deleteById(id);
        log.info("Student with id = " + id + " was deleted.");
    }
}
