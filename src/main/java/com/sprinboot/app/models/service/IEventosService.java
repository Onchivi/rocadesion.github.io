package com.sprinboot.app.models.service;

import java.util.List;
import java.util.Optional;
import com.sprinboot.app.models.entity.Evento;


public interface IEventosService {
	
	public List<Evento> listarEvento();
	public Optional<Evento> listarID(long id);
	public int saveEvento(Evento e);
	public void deleteEvento(long id);

}
