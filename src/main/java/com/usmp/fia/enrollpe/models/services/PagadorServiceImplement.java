package com.usmp.fia.enrollpe.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.usmp.fia.enrollpe.models.dao.IPagadorDao;
import com.usmp.fia.enrollpe.models.entitys.Pagador;

@Service
public class PagadorServiceImplement implements IPagadorService {

	@Autowired
	private IPagadorDao pagadorDao;
	@Override
	@Transactional(readOnly = true)
	public List<Pagador> findAll() {
		// TODO Auto-generated method stub
		return (List<Pagador>)pagadorDao.findAll();
	}

	@Override
	@Transactional
	public void save(Pagador pagador) {
		// TODO Auto-generated method stub
		pagadorDao.save(pagador);
	}

	@Override
	@Transactional(readOnly = true)
	public Pagador findOne(Long id) {
		// TODO Auto-generated method stub
		return pagadorDao.findById(id).orElseGet(null);
	}
}
