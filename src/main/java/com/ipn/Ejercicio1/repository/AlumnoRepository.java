package com.ipn.Ejercicio1.repository;

import com.ipn.Ejercicio1.model.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlumnoRepository extends JpaRepository<Alumno, Integer> {
}
