package com.test.microservice.repository;

import com.test.microservice.domain.Alumno;
import com.test.microservice.domain.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface CursoRepository extends JpaRepository<Curso, Long> {
   Curso findByIdAndState(Long id, Boolean state);

   @Modifying
   @Query(value = "UPDATE Curso SET state=:state WHERE id=:id")
   void updateState(@Param("id") Long id, @Param("state") Boolean state);

   @Query(value = "SELECT COUNT(u.id) FROM Curso u WHERE u.id=:id")
   Long existCurso(@Param("id") Long id);





}
