package com.test.microservice.repository;

import com.test.microservice.domain.Alumno;
import com.test.microservice.domain.Notas;
import com.test.microservice.dto.NotaDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface NotasRepository extends JpaRepository<Notas, Long> {



   @Query(value = "SELECT u.nota FROM Notas u WHERE u.alumno.codigo=:codigo and u.curso.id=:id")
   List<NotaDto> findNotaByAlumnoandCurso(@Param("codigo") String codigo, @Param("id") Long id );

   @Query(value = "SELECT Count(u.nota) FROM Notas u WHERE u.alumno.id=:alumno_id and u.curso.id=:curso_id")
   Long findNota( @Param("alumno_id") Long alumno_id , @Param("curso_id") Long curso_id );
}





