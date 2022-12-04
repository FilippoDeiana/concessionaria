package com.corso.concessionaria.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.corso.concessionaria.entity.ClienteEntity;
import com.corso.concessionaria.services.ClienteService;

@Controller
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;
	
	@GetMapping("/lista")
	public String listaAuto(Model model) {

		model.addAttribute("clienti", clienteService.listaAll());

		return "listaClienti";
	}
	
	@GetMapping("/create")
	public String create(Model model) {

		ClienteEntity clienteEntity = new ClienteEntity();
		model.addAttribute("cliente", clienteEntity);
		
		return "createCliente";
	}
	
	@PostMapping("/create")
	public String save(@ModelAttribute ClienteEntity clienteEntity, Model model) {

		clienteService.save(clienteEntity);
		model.addAttribute("cliente", clienteEntity);
		
		
		return "redirect:/cliente/lista";
	}
	
	@GetMapping("/update/{id}")
	public String edit(@PathVariable Long id, Model model) {

		model.addAttribute("cliente", clienteService.findById(id));
		
		return "updateCliente";
	}
	
	@PostMapping("/update/{id}")
	public String update (@ModelAttribute ClienteEntity clienteEntity) {
	
		clienteService.update(clienteEntity);
		
		return "redirect:/cliente/lista";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable long id, Model model) {

		clienteService.delete(id);
		
		return "redirect:/cliente/lista";
	}
	
	@GetMapping("/{id}")
	public String utenteById(@PathVariable Long id, Model model) {

		
		model.addAttribute("cliente", clienteService.findById(id));
		
		return "utente";
	}
}
