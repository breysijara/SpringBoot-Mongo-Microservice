package com.test.microservice.controller;

import com.test.microservice.service.TestService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
public class TestController {

    private final TestService testService;

    @Value("${test}")
    private String message;

    public TestController(TestService testService) {
        this.testService = testService;
    }

    @GetMapping
    public String test() {
        return message;
    }

    @GetMapping("/sum")
    public Integer sum(@RequestParam("number1") Integer number1,
                       @RequestParam("number2") Integer number2) {
        return this.testService.sum(number1, number2);
    }
}
