package com.corso.concessionaria.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.corso.concessionaria.entity.AutoEntity;
import com.corso.concessionaria.repositories.AutoRepository;

@Service
public class AutoService {

	@Autowired
	private AutoRepository autoRepository;

	public List<AutoEntity> listaAll() {

		return autoRepository.findAll();

	}
	
	public AutoEntity findById(Long id) {

		return autoRepository.findById(id).orElse(null);

	}

	public void save(AutoEntity autoEntity) {

		autoRepository.save(autoEntity);

	}
	
	public void update(AutoEntity autoEntity) {

		if (autoRepository.findById(autoEntity.getId()).isPresent()) {
			autoRepository.save(autoEntity);
		}
		 

	}

}
