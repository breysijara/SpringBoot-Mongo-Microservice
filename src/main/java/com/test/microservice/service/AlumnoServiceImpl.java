package com.test.microservice.service;

import com.test.microservice.config.exception.ConflictException;
import com.test.microservice.domain.Alumno;
import com.test.microservice.dto.AlumnoDto;
import com.test.microservice.dto.CursoDto;
import com.test.microservice.repository.AlumnoRepository;
import com.test.microservice.repository.CursoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class AlumnoServiceImpl implements AlumnoService {

    private final AlumnoRepository alumnoRepository;
    private final CursoRepository cursoRepository;

    @Override
    @Transactional
    public AlumnoDto saveAlumno(AlumnoDto alumnoDto) {

        log.info("Ingresó al método rear categoria");

      /*  Optional<Alumno> existAlumno = alumnoRepository.findById(alumnoDto.getId());
        if (existAlumno.isPresent()) return
*/
        Alumno alumno = new Alumno();
        alumno.setCodigo(alumnoDto.getCodigo());
        alumno.setName(alumnoDto.getName());
        alumno.setApellido(alumnoDto.getApellido());
        alumno.setEdad(alumnoDto.getEdad());
        alumno.setState(true);

        alumnoRepository.save(alumno);
        alumnoDto.setId(alumno.getId());

        return alumnoDto;
    }

    @Override
    public AlumnoDto findAlumno(Long id) {
        Alumno alumno = alumnoRepository.findByIdAndState(id, true);
        if (Objects.isNull(alumno)) return null;
        return AlumnoDto.builder()
                .id(alumno.getId())
                .codigo(alumno.getCodigo())
                .name(alumno.getName())
                .apellido(alumno.getApellido())
                .edad(alumno.getEdad())
                .state(alumno.getState())
                .build();
    }


    @Override
    public List<AlumnoDto> getAllAlumno() {
        List<Alumno> personList = this.alumnoRepository.findAll();

        return personList.stream().map(p -> AlumnoDto.builder()
                        .id(p.getId())
                        .codigo(p.getCodigo())
                        .name(p.getName())
                        .apellido(p.getApellido())
                        .edad(p.getEdad())
                        .state(true)
                        .build())
                .collect(Collectors.toList());
    }


    @Override
    public String updateAlumno(AlumnoDto alumnoDto) throws Exception {

        Alumno alumno = alumnoRepository.findByIdAndState(alumnoDto.getId(), true);
        if (Objects.isNull(alumno)) throw new ConflictException("409_001", "No se encontró a la Alumno");

        alumno.setId(alumnoDto.getId());
        alumno.setCodigo(alumnoDto.getCodigo());
        alumno.setName(alumnoDto.getName());
        alumno.setApellido(alumnoDto.getApellido());
        alumno.setEdad(alumnoDto.getEdad());
        alumno.setState(true);

        alumnoRepository.save(alumno);

     return null;


    }

    @Override
    public String updateStateAlumno(Long id, Boolean state) throws Exception {
        if (!alumnoRepository.existsById(id))
            throw new ConflictException("401", "No se encontró a la Alumno");

        alumnoRepository.updateState(id, state);
        return null;
    }
}
