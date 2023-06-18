package com.hw14_1.students_groups.service;

import com.hw14_1.students_groups.dto.AddCatFromCatFactsDto;
import com.hw14_1.students_groups.dto.AddCatFromRequestDto;
import com.hw14_1.students_groups.entity.Cat;
import com.hw14_1.students_groups.repository.CatRepository;
import com.hw14_1.students_groups.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

@Service
@RequiredArgsConstructor
@Slf4j
public class CatServiceImpl implements CatService {

    private final CatRepository catRepository;
    private final StudentRepository studentRepository;

    @Autowired
    RestTemplate restTemplate;

    @Override
//    @Transactional
    public void addCat(AddCatFromRequestDto addCatFromRequestDto) {
        log.debug("Entrance in addCat method in Cat service implementation");
        Cat cat = new Cat();
        String url = "https://catfact.ninja/fact";
        try {
            AddCatFromCatFactsDto catFactsDto = restTemplate.getForObject(new URI(url), AddCatFromCatFactsDto.class);
            cat.setName(addCatFromRequestDto.getName());
            cat.setFact(catFactsDto.getFact());
            cat.setLenght(catFactsDto.getLenght());
            cat.setStudent(studentRepository.findById(addCatFromRequestDto.getStudent_id())
                    .orElseThrow(() -> {
                        throw new IllegalStateException("can't find student for cat");
                    }));
            catRepository.save(cat);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
        log.debug("Cat name " + cat.getName());
        log.debug("Cat fact" + cat.getFact());

        log.info("Cat was added.");
    }

    @Override
//    @Transactional
    public void deleteCat(Integer id) {
        log.debug("Entrance in deleteCat method in Cat service implementation for cat with id " + id);
        catRepository.deleteById(id);
        log.info("Cat with id = " + id + " was deleted.");
    }
}
