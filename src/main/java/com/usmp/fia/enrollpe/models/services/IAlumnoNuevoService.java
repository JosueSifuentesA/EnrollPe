package com.usmp.fia.enrollpe.models.services;

import java.util.List;

import com.usmp.fia.enrollpe.models.entitys.AlumnoNuevo;

public interface IAlumnoNuevoService {

public List<AlumnoNuevo>findAll();
	
	public void save(AlumnoNuevo alumnoN);
	
	public AlumnoNuevo findOne(Long id);
	
	public void delete(Long id);
}
