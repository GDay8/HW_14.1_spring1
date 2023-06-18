package com.hw14_1.students_groups.controller;

import com.hw14_1.students_groups.dto.AddGroupRequestDto;
import com.hw14_1.students_groups.dto.GroupByIdDto;
import com.hw14_1.students_groups.dto.GetAllGroupsDto;
import com.hw14_1.students_groups.service.GroupService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/groups")
@RequiredArgsConstructor
@Slf4j
public class GroupController {
    private final GroupService groupService;

    @GetMapping
    public List<GetAllGroupsDto> showAllGroups() {
        log.debug("Entrance in getAllGroups method in groups controller");
        List<GetAllGroupsDto> allGroups = groupService.getAllGroups();
        return allGroups;
    }

    @PostMapping
    public void addGroup(@RequestBody AddGroupRequestDto addGroupRequestDto) {
        log.debug("Entrance in addGroup method in groups controller ");
        groupService.addGroup(addGroupRequestDto);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<GroupByIdDto> findGroupById(@PathVariable Integer id) {
        log.debug("Entrance in findGroupById method in groups controller for group with id " + id);
        return ResponseEntity
                .status(200)
                .header("Group info", "Group info")
                .body(groupService.findGroupById(id));
    }


}
