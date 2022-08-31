package com.test.microservice.service;

import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService {

    @Override
    public Integer sum(Integer number1, Integer number2) {
        return number1 + number2;
    }
}
