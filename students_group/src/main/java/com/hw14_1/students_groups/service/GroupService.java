package com.hw14_1.students_groups.service;

import com.hw14_1.students_groups.dto.AddGroupRequestDto;
import com.hw14_1.students_groups.dto.GetAllGroupsDto;
import com.hw14_1.students_groups.dto.GroupByIdDto;
import com.hw14_1.students_groups.entity.Group;
import com.hw14_1.students_groups.entity.Student;

import java.util.List;

public interface GroupService {

    public List<GetAllGroupsDto> getAllGroups();

    public void addGroup(AddGroupRequestDto addGroupRequestDto);

    public GroupByIdDto findGroupById (Integer id);

}
