package com.test.microservice.service;

import java.util.List;
import com.test.microservice.dto.AlumnoDto;

public interface AlumnoService {

    AlumnoDto saveAlumno(AlumnoDto alumno);

    AlumnoDto findAlumno(Long id) ;

    List<AlumnoDto> getAllAlumno();

    String updateAlumno(AlumnoDto alumnoDto) throws Exception;

    String updateStateAlumno(Long id, Boolean state) throws Exception;
}
