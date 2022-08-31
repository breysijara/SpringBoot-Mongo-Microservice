package com.test.microservice.controller;


import com.test.microservice.dto.NotaDto;
import com.test.microservice.service.NotasService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/Nota")
@Validated
@RequiredArgsConstructor
public class NotaController {
    private final NotasService notasService;

    @PostMapping
    public NotaDto saveNota(@RequestBody NotaDto notaDto) {
        return this.notasService.saveNotas(notaDto);
    }



    @GetMapping
    public List<NotaDto> getAll() {
        return this.notasService.findAll();
    }





}