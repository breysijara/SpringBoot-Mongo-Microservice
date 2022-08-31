package com.test.microservice.service;

import com.test.microservice.domain.Person;
import com.test.microservice.dto.PersonDto;
import com.test.microservice.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    @Override
    @Transactional
    public PersonDto createPerson(PersonDto personDto) {
        // Lógica para guardar a la persona en base de datos
        log.info("Ingresó al método createPerson");

        Person person = new Person();
        person.setName(personDto.getName());
        person.setGender(personDto.getGender());
        person.setAddress(personDto.getAddress());
        this.personRepository.save(person);

        personDto.setId(person.getId());

        return personDto;
    }

    @Override
    public List<String> updatePerson(List<PersonDto> personDtoList) {
        // Lógica para actualizar a la persona en base de datos

        return personDtoList.stream()
                .filter(p -> p.getGender().equals("M"))
                .map(p -> p.getName())
                .collect(Collectors.toList());
    }

    @Override
    public PersonDto getPersonById(Long id) {
        Optional<Person> optionalPerson = this.personRepository.findById(id);
        if (optionalPerson.isPresent()) {
            Person person = optionalPerson.get();
            return PersonDto.builder()
                    .id(person.getId())
                    .name(person.getName())
                    .gender(person.getGender())
                    .address(person.getAddress())
                    .build();
        }
        // manejo de errores -> No Content 204 Error HTTP 404,
        return null;
    }

    //
}
