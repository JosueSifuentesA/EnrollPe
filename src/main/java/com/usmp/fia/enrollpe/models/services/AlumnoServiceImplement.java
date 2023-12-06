package com.usmp.fia.enrollpe.models.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.usmp.fia.enrollpe.models.dao.IAlumnoDao;
import com.usmp.fia.enrollpe.models.entitys.Alumno;

@Service
public class AlumnoServiceImplement implements IAlumnoService {

	@Autowired
	private IAlumnoDao alumnoDao;
	@Override
	@Transactional(readOnly = true)
	public List<Alumno> findAll() {
		// TODO Auto-generated method stub
		return (List<Alumno>)alumnoDao.findAll();
	}

	@Override
	@Transactional
	public void save(Alumno alumno) {
		// TODO Auto-generated method stub
		alumnoDao.save(alumno);
	}

	@Override
	@Transactional(readOnly = true)
	public Alumno findOne(Long id) {
		// TODO Auto-generated method stub
		return alumnoDao.findById(id).orElseGet(null);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		alumnoDao.deleteById(id);
	}

}
