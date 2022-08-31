package com.test.microservice.service;

import com.test.microservice.dto.PersonDto;

import java.util.List;

public interface PersonService {

    PersonDto createPerson(PersonDto personDto);

    List<String> updatePerson(List<PersonDto> personDtoList);

    PersonDto getPersonById(Long id);
}
