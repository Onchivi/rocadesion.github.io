package com.sprinboot.app.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.sprinboot.app.models.entity.Integrantes;

public interface IintegrantesDao extends CrudRepository<Integrantes, Long>{
	
	@Query("select p from Integrantes p where p.name like %?1%")
	public List<Integrantes> findbyNombre(String nombre);
	

}
