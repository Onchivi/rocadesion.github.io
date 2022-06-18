package com.sprinboot.app.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.sprinboot.app.models.entity.Evento;
import com.sprinboot.app.models.service.IEventosService;


@Controller
public class EventosController {
	
	@Autowired(required = true)
	private IEventosService service;
	
	@GetMapping("/listarEvento")
	public String listar(Model model) {
		List<Evento>eventos=service.listarEvento();
		model.addAttribute("eventos", eventos);
		return "GestionarEventos";
	}
	
	@GetMapping("/CrearEvento")
	public String agregar(Model model) {
		model.addAttribute("evento", new Evento());
		return "CrearEvento";
	}
	
	@PostMapping("/GuardarEvento")
	public String save(@Validated Evento e, Model model){
		service.saveEvento(e);
		return "redirect:/listarEvento";
	}
	
	@GetMapping("/editarEvento/{id}")
	public String editar(@PathVariable int id, Model model) {
		Optional<Evento>evento=service.listarID(id);  
		model.addAttribute("evento",evento);
		return "CrearEvento";
	}
	
	@GetMapping("/eliminarEvento/{id}")
	public String delete(@PathVariable int id , Model model) {
		service.deleteEvento(id); 
		return "redirect:/listarEvento";
	}

}
