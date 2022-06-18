package com.sprinboot.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.sprinboot.app.models.entity.Asistencia;
import com.sprinboot.app.models.entity.Integrantes;
import com.sprinboot.app.models.service.IAsistenciaService;
import com.sprinboot.app.models.service.IintegrantesServices;

@Controller
public class AsistenciaController {
	
	@Autowired
	private IAsistenciaService asistenciaDao;
	
	@Autowired
	private IintegrantesServices integrantesDao;
	
	
	
	
	@GetMapping(value = "listarAsistencias")
	public String listar(Model model) {
		
		
		model.addAttribute("asistencias", asistenciaDao.findAll());
		
		return "GestionarAsistencia";
			
	}
	

	
	@GetMapping("/form/{integranteId}")
	public String crearAsistencia(@PathVariable(value = "integranteId") Long integranteId,Model model, Asistencia asiste) {
		
		Integrantes integrante = integrantesDao.findOne(integranteId);
		
		Asistencia asistencia = new Asistencia();
		
		asistencia.setIntegrantes(integrante);
		asistencia.setNombre(integrante.getName());
		asistencia.setApellido(integrante.getLastname());
		
		asistenciaDao.save(asistencia);

		return "redirect:/listarAsistencias";

	}
	

	@GetMapping("/eliminarAsistencia/{id}")
	public String delete(Model model, @PathVariable long id) {
		
		Asistencia asistencia = asistenciaDao.findOne(id);
		asistenciaDao.delete(id);
		return "redirect:/listarAsistencias";
	}
	
	@GetMapping(value = "Guia")
	public String informacion() {
		
		return "Guia";
	}
	
	
	@GetMapping(value = "home")
	public String home() {
		
		return "index";
	}
	
	
}
