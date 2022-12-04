package com.corso.concessionaria.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.corso.concessionaria.entity.AutoEntity;

@Repository
public interface AutoRepository extends JpaRepository<AutoEntity, Long>{

}
