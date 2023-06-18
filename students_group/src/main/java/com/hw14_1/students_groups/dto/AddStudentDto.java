package com.hw14_1.students_groups.dto;

import com.hw14_1.students_groups.entity.Group;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class AddStudentDto {

    private String name;
    private Integer group_id;

}
