package com.sprinboot.app.models.service;


import java.util.List;


import com.sprinboot.app.models.entity.Asistencia;

public interface IAsistenciaService {
	
	
	public List<Asistencia> findAll();
	
	public void save(Asistencia asistencia);
	
	public Asistencia findOne(long id);
	
	public void delete (long id);
	
	public List<Asistencia> buscarPorNombre (String nombre); // BUSCAR POR NOMBRE 
}
