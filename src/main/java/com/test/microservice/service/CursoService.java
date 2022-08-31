package com.test.microservice.service;


import com.test.microservice.dto.AlumnoDto;
import com.test.microservice.dto.CategoryDto;
import com.test.microservice.dto.CursoDto;

import java.util.List;

public interface CursoService {

    CursoDto saveCurso(CursoDto cursoDto);

    CursoDto findCurso(Long id) ;

    List<CursoDto> getAllCurso();

    String updateCurso(CursoDto cursoDto) throws Exception;

    String updateStateCurso(Long id, Boolean state) throws Exception;
}
