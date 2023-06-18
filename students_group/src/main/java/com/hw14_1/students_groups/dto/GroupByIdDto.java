package com.hw14_1.students_groups.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GroupByIdDto {

    private Integer id;
    private String name;
    private List<GetStudentsInGroupDto> students;

}
