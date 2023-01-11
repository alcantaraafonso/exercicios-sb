package br.com.beganinha.exerciciossb.model.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import br.com.beganinha.exerciciossb.model.entities.Produto;

/**
 * A interface PagingAndSortingRepository provê uma forma simples de fazer consulta paginada
 *
 */
public interface ProdutoRepository extends 
			CrudRepository<Produto, Integer>, PagingAndSortingRepository<Produto, Integer> {
	
	/**
	 * O SpringBoot implementará esse método
	 * Para que essa implmentação funcione, é necessário que o nome do método obedeça a convenção do Spring, exemplo:
	 * Para realizar uma busca, o método precisa começar com "find" e como se deseja que faça uma like precisa-se que
	 * o find seja seguindo de By<O nome do atributo definido na entidade que se que busca>Containing
	 * OBS: Deve-se usar o nome exato do atributo definido na entidade 
	 * @param name
	 * @return
	 */
	public Iterable<Produto> findByNomeContaining(String name);
	
	/**
	 * Seguindo a convenção, o método fará um lile ignorando CAPS LOCK
	 * @param name
	 * @return
	 */
	public Iterable<Produto> findByNomeContainingIgnoreCase(String name);
	
	public Iterable<Produto> findByNomeIsContaining(String name);
	
	public Iterable<Produto> findByNomeContains(String name);
	
	public Iterable<Produto> findByNomeStartsWith(String name);
	
	public Iterable<Produto> findByNomeEndsWith(String name);
	
	public Iterable<Produto> findByNomeNotContaining(String name);
	
	@Query("SELECT p FROM Produto p WHERE p.nome LIKE %:nome%")
	public Iterable<Produto> searchByNameLike(@Param("nome") String name);
	
	

}
