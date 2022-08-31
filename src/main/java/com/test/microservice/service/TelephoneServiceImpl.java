package com.test.microservice.service;

import com.test.microservice.domain.Person;
import com.test.microservice.domain.Telephone;
import com.test.microservice.dto.TelephoneDto;
import com.test.microservice.repository.PersonRepository;
import com.test.microservice.repository.TelephoneRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TelephoneServiceImpl implements TelephoneService{

    private final PersonRepository personRepository;
    private final TelephoneRepository telephoneRepository;

    @Override
    public TelephoneDto createTelephone(TelephoneDto telephoneDto) {

        Optional<Person> optionalPerson = this.personRepository.findById(telephoneDto.getPerson().getId());
        if (optionalPerson.isPresent()) {
            Person person = optionalPerson.get();
            Telephone telephone = new Telephone();
            telephone.setNumber(telephoneDto.getNumber());
            telephone.setOperator(telephoneDto.getOperator());
            telephone.setPerson(person);
            this.telephoneRepository.save(telephone);

            telephoneDto.setId(telephone.getId());
            telephoneDto.getPerson().setName(telephone.getPerson().getName());
            telephoneDto.getPerson().setGender(telephone.getPerson().getGender());
            return telephoneDto;
        }

        // Enviar un mensaje de que no hay la persona
        return null;
    }
}
