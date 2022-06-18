package com.sprinboot.app.models.service;

import java.util.List;
import java.util.Optional;

import com.sprinboot.app.models.entity.Asistencia;
import com.sprinboot.app.models.entity.Integrantes;


public interface IintegrantesServices {

	public List<Integrantes> listar();

	public Optional<Integrantes> listarId(long id);

	public int save(Integrantes integrantes);

	public void delete(long id);
	
	public Integrantes findOne(long id);
	
	public List<Integrantes> buscarPorNombre (String nombre); // BUSCAR POR NOMBRE 

}
