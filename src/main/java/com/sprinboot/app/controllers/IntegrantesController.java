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
import org.springframework.web.bind.annotation.RequestMapping;

import com.sprinboot.app.models.entity.Integrantes;
import com.sprinboot.app.models.service.IintegrantesServices;


@Controller
@RequestMapping
public class IntegrantesController {

	@Autowired(required = true)
	private IintegrantesServices service;

	@GetMapping("/listar")
	public String listar(Model model) {
		List<Integrantes> integrantes = service.listar();
		model.addAttribute("integrantes", integrantes);
		return "GestionarIntegrantes";
	}

	@GetMapping("/new")
	public String agregar(Model model) {
		model.addAttribute("integrante", new Integrantes());
		return "RegistrarIntegrantes";
	}

	@PostMapping("/save")
	public String save(@Validated Integrantes p, Model model) {
		service.save(p);
		return "redirect:/listar";
	}

	@GetMapping("/editar/{id}")
	public String editar(@PathVariable int id, Model model) {
		Optional<Integrantes> integrante = service.listarId(id);
		model.addAttribute("integrante", integrante);
		return "RegistrarIntegrantes";
	}

	@GetMapping("/eliminar/{id}")
	public String delete(Model model, @PathVariable int id) {
		service.delete(id);
		return "redirect:/listar";
	}
}
