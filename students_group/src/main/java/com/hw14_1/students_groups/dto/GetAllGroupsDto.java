package com.hw14_1.students_groups.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetAllGroupsDto {

    private Integer id;
    private String name;
    private int studentsQuantity;

}
