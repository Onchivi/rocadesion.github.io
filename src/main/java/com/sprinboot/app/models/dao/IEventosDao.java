package com.sprinboot.app.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.sprinboot.app.models.entity.Evento;

public interface IEventosDao extends CrudRepository<Evento, Long>{
	

}
