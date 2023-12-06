package com.usmp.fia.enrollpe.models.services;

import java.util.List;

import com.usmp.fia.enrollpe.models.entitys.Alumno;

public interface IAlumnoService {

	public List<Alumno>findAll();
	
	public void save (Alumno alumno);
	
	public Alumno findOne(Long id);
	
	public void delete(Long id);
}
