package com.test.microservice.service;

import com.test.microservice.config.exception.ConflictException;
import com.test.microservice.domain.Category;
import com.test.microservice.domain.Curso;
import com.test.microservice.dto.CategoryDto;
import com.test.microservice.dto.CursoDto;
import com.test.microservice.repository.CategoryRepository;
import com.test.microservice.repository.CursoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class CursoServiceImpl implements CursoService {

    private final CursoRepository cursoRepository;

    @Override
    public CursoDto saveCurso(CursoDto cursoDto) {
        Curso curso = new Curso();
        curso.setDescripcion(cursoDto.getDescripcion());
        curso.setState(true);

        cursoRepository.save(curso);
        cursoDto.setId(curso.getId());

        return cursoDto;
    }

    @Override
    public CursoDto findCurso(Long id) {
        Curso curso = cursoRepository.findByIdAndState(id, true);
        if (Objects.isNull(curso)) return null;
        return CursoDto.builder()
                .id(curso.getId())
                .descripcion(curso.getDescripcion())
                .state(curso.getState())
                .build();
    }

    @Override
    public List<CursoDto> getAllCurso() {
        List<Curso> personList = this.cursoRepository.findAll();

        return personList.stream().map(p -> CursoDto.builder()
                        .id(p.getId())
                        .descripcion(p.getDescripcion())

                        .state(true)
                        .build())
                .collect(Collectors.toList());
    }

    @Override
    public String updateCurso(CursoDto cursoDto) throws Exception {
        Curso curso = cursoRepository.findByIdAndState(cursoDto.getId(), true);
        if (Objects.isNull(curso)) throw new ConflictException("409_001", "No se encontró El curso");
        curso.setId(cursoDto.getId());
        curso.setDescripcion(cursoDto.getDescripcion());
        curso.setState(true);

        cursoRepository.save(curso);

        return null;
    }

    @Override
    public String updateStateCurso(Long id, Boolean state) throws Exception {
        if (!cursoRepository.existsById(id))
            throw new ConflictException("401", "No se encontró a la curso");

        cursoRepository.updateState(id, state);
        return null;
    }
}
