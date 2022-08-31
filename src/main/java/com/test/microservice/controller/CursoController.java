package com.test.microservice.controller;


import com.test.microservice.dto.AlumnoDto;
import com.test.microservice.dto.CursoDto;
import com.test.microservice.service.AlumnoService;
import com.test.microservice.service.CursoService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/curso")
@Validated
@RequiredArgsConstructor
public class CursoController {
    private final CursoService cursoService;

    @PostMapping
    public CursoDto saveCurso(@RequestBody CursoDto cursoDto) {

        return this.cursoService.saveCurso(cursoDto);
    }


    @GetMapping("/{id}")
    public CursoDto getCursoById(@PathVariable("id") Long id) {
        return this.cursoService.findCurso(id);
    }

    @GetMapping
    public List<CursoDto> getAllCurso() {
        return this.cursoService.getAllCurso();
    }


    @PutMapping("")
    public String updateCurso(@RequestBody CursoDto cursoDto) throws Exception {
        String save = cursoService.updateCurso(cursoDto);
        return save;
    }

    @ApiOperation("Activar/Desactivar una curso")
    @PostMapping("/{id}")
    public String stateCurso(@PathVariable("id") Long id,Boolean state) throws Exception {
        String save = cursoService.updateStateCurso(id, state);
    return save;
    }



}