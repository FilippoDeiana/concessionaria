package com.corso.concessionaria.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.corso.concessionaria.entity.AutoEntity;
import com.corso.concessionaria.entity.ClienteEntity;
import com.corso.concessionaria.repositories.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	public List<ClienteEntity> listaAll() {

		return clienteRepository.findAll();

	}
	
	public ClienteEntity findById(Long id) {

		return clienteRepository.findById(id).orElse(null);

	}

	public void save(ClienteEntity clienteEntity) {

		clienteRepository.save(clienteEntity);

	}
	
	public void update(ClienteEntity clienteEntity) {

		if (clienteRepository.findById(clienteEntity.getId()).isPresent()) {
			clienteRepository.save(clienteEntity);
		}
		 

	}
	
	public void delete(Long id) {

		clienteRepository.deleteById(id);

	}

}
