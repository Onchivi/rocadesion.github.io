package com.sprinboot.app.models.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprinboot.app.models.entity.Evento;

import com.sprinboot.app.models.dao.IEventosDao;


@Service
public class IEventosServiceImpl implements IEventosService{
	
	@Autowired
	private IEventosDao IEventosDao;

	@Override
	public List<Evento> listarEvento() {
		// TODO Auto-generated method stub
		return (List<Evento>)IEventosDao.findAll();
	}

	@Override
	public Optional<Evento> listarID(long id) {
		// TODO Auto-generated method stub
		return IEventosDao.findById(id);
	}

	@Override
	public int saveEvento(Evento e) {
		int res=0;
		Evento evento=IEventosDao.save(e);
		if(!evento.equals(null)) {
			res=1;
		}
		return res;
	}

	@Override
	public void deleteEvento(long id) {
		IEventosDao.deleteById(id);
		
	}

}
