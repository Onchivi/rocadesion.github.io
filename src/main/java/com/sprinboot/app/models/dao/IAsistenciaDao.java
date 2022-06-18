package com.sprinboot.app.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.sprinboot.app.models.entity.Asistencia;

public interface IAsistenciaDao extends CrudRepository<Asistencia, Long>{
	
	@Query("select p from Asistencia p where p.nombre like %?1%")
	public List<Asistencia> findbyNombre(String nombre);

	
}
