package com.hw14_1.students_groups.controller;

import com.hw14_1.students_groups.dto.AddCatFromRequestDto;
import com.hw14_1.students_groups.service.CatService;
import com.hw14_1.students_groups.service.CatServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cats")
@RequiredArgsConstructor
@Slf4j
public class CatController {

    private CatService catService;

    @PostMapping()
    public void addCat(@RequestBody AddCatFromRequestDto addCatFromRequestDto) {
        log.debug("Entrance in addCat method in Cats controller");
        catService.addCat(addCatFromRequestDto);
    }

    @DeleteMapping("/{id}")
    public void deleteCat(@PathVariable Integer id) {
        log.debug("Entrance in deleteCat method in cats controller");
        catService.deleteCat(id);


    }

}
