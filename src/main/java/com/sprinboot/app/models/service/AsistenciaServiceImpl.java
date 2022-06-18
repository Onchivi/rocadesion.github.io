package com.sprinboot.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.sprinboot.app.models.dao.IAsistenciaDao;
import com.sprinboot.app.models.entity.Asistencia;


@Service
public class AsistenciaServiceImpl implements IAsistenciaService{

	@Autowired
	private IAsistenciaDao asistenciaDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Asistencia> findAll() {
		
		 return (List<Asistencia>)asistenciaDao.findAll();
	}

	@Override
	@Transactional
	public void save(Asistencia asistencia) {
		asistenciaDao.save(asistencia);

	}

	
	@Override
	@Transactional(readOnly=true)
	public Asistencia findOne(long id) {
		
		return asistenciaDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(long id) {
		
		asistenciaDao.deleteById(id);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Asistencia> buscarPorNombre(String nombre) {
		// TODO Auto-generated method stub
		return asistenciaDao.findbyNombre(nombre);
	}



}
