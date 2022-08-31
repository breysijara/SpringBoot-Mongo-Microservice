package com.test.microservice.controller;


import com.test.microservice.dto.AlumnoDto;
import com.test.microservice.dto.CategoryDto;
import com.test.microservice.service.AlumnoService;
import com.test.microservice.service.CategoryService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/alumno")
@Validated
@RequiredArgsConstructor
public class AlumnoController {
    private final AlumnoService alumnoService;

    @PostMapping
    public AlumnoDto saveAlumno(@RequestBody AlumnoDto alumnoDto) {
        return this.alumnoService.saveAlumno(alumnoDto);
    }


    @GetMapping("/{id}")
    public AlumnoDto getAlumnoById(@PathVariable("id") Long id) {
        return this.alumnoService.findAlumno(id);
    }

    @GetMapping
    public List<AlumnoDto> getAllAlumno() {
        return this.alumnoService.getAllAlumno();
    }


    @PutMapping("")
    public String updateAlumno(@RequestBody AlumnoDto alumnoDto) throws Exception {
        String save = alumnoService.updateAlumno(alumnoDto);
        return save;
    }

    @ApiOperation("Activar/Desactivar una Alumno")
    @PostMapping("/{id}")
    public String stateAlumno(@PathVariable("id") Long id,Boolean state) throws Exception {
        String save = alumnoService.updateStateAlumno(id, state);
    return save;
    }



}