package com.test.microservice.repository;

import com.test.microservice.domain.Alumno;
import com.test.microservice.domain.Category;
import com.test.microservice.dto.AlumnoDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface AlumnoRepository extends JpaRepository<Alumno, Long> {

   Alumno findByIdAndState(Long id, Boolean state);

   @Modifying
   @Query(value = "UPDATE Alumno SET state=:state WHERE id=:id")
   void updateState(@Param("id") Long id, @Param("state") Boolean state);


}