package br.com.beganinha.exerciciossb.model.repositories;

import org.springframework.data.repository.CrudRepository;

import br.com.beganinha.exerciciossb.model.entities.Produto;

public interface ProdutoRepository extends CrudRepository<Produto, Integer> {

	
}
