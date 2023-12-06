package com.usmp.fia.enrollpe.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.usmp.fia.enrollpe.models.entitys.Alumno;

public interface IAlumnoDao extends CrudRepository<Alumno, Long> {

}
