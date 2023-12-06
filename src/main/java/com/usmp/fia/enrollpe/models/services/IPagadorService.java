package com.usmp.fia.enrollpe.models.services;

import java.util.List;

import com.usmp.fia.enrollpe.models.entitys.Pagador;

public interface IPagadorService {
public List<Pagador>findAll();
	
	public void save (Pagador pagador);

	public Pagador findOne(Long id);
}
