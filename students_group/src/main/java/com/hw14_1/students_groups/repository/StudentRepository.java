package com.hw14_1.students_groups.repository;

import com.hw14_1.students_groups.entity.Group;
import com.hw14_1.students_groups.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository <Student, Integer> {
}
