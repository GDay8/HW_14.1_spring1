package com.hw14_1.students_groups.service;

import com.hw14_1.students_groups.dto.AddGroupRequestDto;
import com.hw14_1.students_groups.dto.GetAllGroupsDto;
import com.hw14_1.students_groups.dto.GetStudentsInGroupDto;
import com.hw14_1.students_groups.dto.GroupByIdDto;
import com.hw14_1.students_groups.entity.Group;
import com.hw14_1.students_groups.entity.Student;
import com.hw14_1.students_groups.repository.GroupRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class GroupServiceImpl implements GroupService {

    private final GroupRepository groupRepository;

    @Override
//    @Transactional
    public List<GetAllGroupsDto> getAllGroups() {
        List<Group> groups = groupRepository.findAll();
        return groups.stream()
                .map(group -> getAllGroupsDtoFromGroup(group))
                .toList();
    }

    @Override
//    @Transactional
    public void addGroup(AddGroupRequestDto addGroupRequestDto) {
        log.debug("Entrance in addGroup method in Group service implementation");
        Group group = new Group();
        group.setName(addGroupRequestDto.getName());
        log.debug("Group name " + group.getName());
        groupRepository.save(group);
        log.info("Group was added");
    }

    @Override
    public GroupByIdDto findGroupById(Integer id) {
        log.debug("Entrance in findgroupById method in Group service implementation");
        Group group = groupRepository.findById(id).orElseThrow(() -> {
            throw new IllegalStateException("can't find group with id" + id);
        });
        GroupByIdDto groupByIdDto = new GroupByIdDto();
        groupByIdDto.setId(group.getGroup_id());
        groupByIdDto.setName(group.getName());
        groupByIdDto.setStudents(group.getStudents().
                stream().
                map(GroupServiceImpl::getStudentInGroupDTOFromStudent)
                .collect(Collectors.toList()));
        return groupByIdDto;
    }

    private static GetAllGroupsDto getAllGroupsDtoFromGroup(Group group) {
        GetAllGroupsDto getAllGroupsDto = new GetAllGroupsDto();
        getAllGroupsDto.setId(group.getGroup_id());
        getAllGroupsDto.setName(group.getName());
        getAllGroupsDto.setStudentsQuantity(group.getStudents().size());
        return getAllGroupsDto;
    }

    private static GetStudentsInGroupDto getStudentInGroupDTOFromStudent(Student student) {
        GetStudentsInGroupDto getStudentsInGroupDto = new GetStudentsInGroupDto();
        getStudentsInGroupDto.setStudent_id(student.getStudent_id());
        getStudentsInGroupDto.setName(student.getName());
        getStudentsInGroupDto.setEntranceDate(student.getEntranceDate());
        return getStudentsInGroupDto;
    }

}
