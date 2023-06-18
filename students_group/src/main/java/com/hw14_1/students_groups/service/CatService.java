package com.hw14_1.students_groups.service;

import com.hw14_1.students_groups.dto.AddCatFromRequestDto;

public interface CatService {

    public void addCat(AddCatFromRequestDto addCatFromRequestDto);

    public void deleteCat(Integer id);

}
