package com.test.microservice.service;


import com.test.microservice.dto.AlumnoDto;
import com.test.microservice.dto.CategoryDto;
import com.test.microservice.dto.NotaDto;

import java.util.List;

public interface NotasService {

    NotaDto saveNotas(NotaDto nota);

    List<NotaDto> findAll();
    //NotaDto findAlumno(Long id) ;

    /*List<AlumnoDto> getAllAlumno();

    String updateAlumno(AlumnoDto alumnoDto) throws Exception;

    String updateStateAlumno(Long id, Boolean state) throws Exception;*/
}


