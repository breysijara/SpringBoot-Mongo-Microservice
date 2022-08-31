package com.test.microservice.controller;

import com.test.microservice.dto.PersonDto;
import com.test.microservice.dto.TelephoneDto;
import com.test.microservice.service.TelephoneService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/telephones")
@RequiredArgsConstructor
public class TelephoneController {

    private final TelephoneService telephoneService;

    @PostMapping
    public TelephoneDto createTelephone(@RequestBody TelephoneDto telephoneDto) {
        return this.telephoneService.createTelephone(telephoneDto);
    }
}
