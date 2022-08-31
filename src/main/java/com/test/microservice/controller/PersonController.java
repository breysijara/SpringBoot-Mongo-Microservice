package com.test.microservice.controller;

import com.test.microservice.dto.PersonDto;
import com.test.microservice.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/persons")
@RequiredArgsConstructor
public class PersonController {

    private final PersonService personService;

    @PostMapping
    public PersonDto createPerson(@RequestBody PersonDto personDto) {
        return this.personService.createPerson(personDto);
    }

    @PutMapping
    public List<String> updatePerson(@RequestBody List<PersonDto> personDtoList) {
        return this.personService.updatePerson(personDtoList);
    }

    @GetMapping("/{id}")
    public PersonDto getPersonById(@PathVariable("id") Long id) {
        return this.personService.getPersonById(id);
    }

    // 1. EndPoint GET retorne todos los persons que hay en BD
    // 2. Endpoint DELETE elimine el person que contenga el ID que pasan por parametro

}
