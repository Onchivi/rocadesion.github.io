package com.sprinboot.app.models.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sprinboot.app.models.dao.IintegrantesDao;
import com.sprinboot.app.models.entity.Integrantes;


@Service
public class IntegrantesServiceImpl implements IintegrantesServices {

	@Autowired
	private IintegrantesDao integranteDao;

	@Override
	public List<Integrantes> listar() {

		return (List<Integrantes>) integranteDao.findAll();
	}

	@Override
	public Optional<Integrantes> listarId(long id) {

		return integranteDao.findById(id);
	}

	@Override
	public int save(Integrantes p) {
		int res = 0;
		Integrantes persona = integranteDao.save(p);
		if (persona.equals(null)) {
			res = 1;
		}
		return res;
	}

	@Override
	public void delete(long id) {
		integranteDao.deleteById(id);

	}

	@Override
	public Integrantes findOne(long id) {
		
		return integranteDao.findById(id).orElse(null);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Integrantes> buscarPorNombre(String nombre) {
		// TODO Auto-generated method stub
		return integranteDao.findbyNombre(nombre);
	}

}
