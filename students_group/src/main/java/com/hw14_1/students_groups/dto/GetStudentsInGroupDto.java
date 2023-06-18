package com.hw14_1.students_groups.dto;


import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class GetStudentsInGroupDto {

    private Integer student_id;
    private String name;
    private LocalDateTime entranceDate;

}
