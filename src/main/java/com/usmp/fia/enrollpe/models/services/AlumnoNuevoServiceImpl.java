package com.usmp.fia.enrollpe.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.usmp.fia.enrollpe.models.dao.IAlumnoNuevoDao;
import com.usmp.fia.enrollpe.models.entitys.AlumnoNuevo;

@Service
public class AlumnoNuevoServiceImpl implements IAlumnoNuevoService {

	@Autowired
	private IAlumnoNuevoDao alumnoNuevoDao;
	@Override
	@Transactional(readOnly = true)
	public List<AlumnoNuevo> findAll() {
		// TODO Auto-generated method stub
		return (List<AlumnoNuevo>)alumnoNuevoDao.findAll();
	}

	@Override
	@Transactional
	public void save(AlumnoNuevo alumnoN) {
		// TODO Auto-generated method stub
		alumnoNuevoDao.save(alumnoN);
	}

	@Override
	@Transactional(readOnly = true)
	public AlumnoNuevo findOne(Long id) {
		// TODO Auto-generated method stub
		return alumnoNuevoDao.findById(id).orElseGet(null);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		alumnoNuevoDao.deleteById(id);
	}

}
