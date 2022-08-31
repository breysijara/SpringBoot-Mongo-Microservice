package com.test.microservice.service;

import com.test.microservice.config.exception.ConflictException;
import com.test.microservice.domain.Alumno;
import com.test.microservice.domain.Category;
import com.test.microservice.domain.Curso;
import com.test.microservice.domain.Notas;
import com.test.microservice.dto.AlumnoDto;
import com.test.microservice.dto.CategoryDto;
import com.test.microservice.dto.NotaDto;
import com.test.microservice.repository.AlumnoRepository;
import com.test.microservice.repository.CategoryRepository;
import com.test.microservice.repository.CursoRepository;
import com.test.microservice.repository.NotasRepository;
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
public class NotasServiceImpl implements NotasService {

    private final AlumnoRepository alumnoRepository;
    private final CursoRepository cursoRepository;
    private final NotasRepository notasRepository;

    @Override
    public NotaDto saveNotas(NotaDto notaDto) {

        Alumno alumno = alumnoRepository.findByIdAndState(notaDto.getAlumno_id(), true);
        if (Objects.isNull(alumno)) throw new ConflictException("409_001", "No se encontró a la Alumno");

        Curso curso = cursoRepository.findByIdAndState(notaDto.getCurso_id(), true);
        if (Objects.isNull(curso)) throw new ConflictException("409_001", "No se encontró El curso");

        Long exitNota = notasRepository.findNota(notaDto.getAlumno_id(),notaDto.getCurso_id());
        if (exitNota.intValue() > 0) throw new ConflictException("409_001", "La nota ya se registro en el curso y alumno");

        Notas nota = new Notas();
        nota.setNota(notaDto.getNota());
        nota.setAlumno(alumno);
        nota.setCurso(curso);

        notasRepository.save(nota);
        notaDto.setId(nota.getId());


        return notaDto;


    }


    @Override
    @Transactional
    public List<NotaDto> findAll() {
        List<Notas> notasList = this.notasRepository.findAll();

        return notasList.stream().map(p -> NotaDto.builder()
                        .id(p.getId())
                        .nota(p.getNota())
                        .Alumno_id(p.getAlumno().getId())
                        .Curso_id(p.getCurso().getId())
                        .build())
                .collect(Collectors.toList());
    }


}
