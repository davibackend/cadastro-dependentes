package com.compasso.challenge.register.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.compasso.challenge.register.domain.model.BaseObject;

/*
 * //TODO verificar possibilidade
 * O JpaRepository não aceita os metodos findByEmail e findByCpf
 * pois quando acessado diretamente pelo GenericService ainda nao definiu o tipo e não encontra a entidade.
 */
@Repository
public interface GenericRepository<E extends BaseObject> extends JpaRepository<E, Long> {

}
