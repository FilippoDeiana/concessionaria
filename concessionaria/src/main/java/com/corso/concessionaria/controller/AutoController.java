package com.corso.concessionaria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.corso.concessionaria.entity.AutoEntity;
import com.corso.concessionaria.services.AutoService;
import com.corso.concessionaria.services.ClienteService;


@Controller
@RequestMapping("/auto")
public class AutoController {
	
	@Autowired
	private AutoService autoService;
	@Autowired
	private ClienteService clienteService;
	
	@GetMapping("/lista")
	public String listaAuto(Model model) {

		model.addAttribute("autos", autoService.listaAll());

		return "listaAuto";
	}
	
	@GetMapping("/create")
	public String create(Model model) {

		AutoEntity autoEntity = new AutoEntity();
		model.addAttribute("auto", autoEntity);
		model.addAttribute("clienti", clienteService.listaAll());
		return "createAuto";
	}
	
	@PostMapping("/create")
	public String save(@ModelAttribute AutoEntity autoEntity, Model model) {

		autoService.save(autoEntity);
		model.addAttribute("auto", autoEntity);
		
		
		return "redirect:/auto/lista";
	}
	
	@GetMapping("/update/{id}")
	public String edit(@PathVariable long id, Model model) {

		model.addAttribute("auto", autoService.findById(id));
		model.addAttribute("clienti", clienteService.listaAll());
		return "updateAuto";
	}
	
	@PostMapping("/update/{id}")
	public String update (@ModelAttribute AutoEntity autoEntity) {
	
		autoService.update(autoEntity);
		
		return "redirect:/auto/lista";
	}
	
	@GetMapping("/{id}")
	public String utenteById(@PathVariable Long id, Model model) {

		
		model.addAttribute("auto", autoService.findById(id));
		
		return "auto";
	}

}
