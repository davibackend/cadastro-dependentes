package com.compasso.desafio.cadastro.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.compasso.desafio.cadastro.domain.model.BaseObject;

@Repository
public interface GenericRepository<E extends BaseObject> extends JpaRepository<E, Long> {

}
