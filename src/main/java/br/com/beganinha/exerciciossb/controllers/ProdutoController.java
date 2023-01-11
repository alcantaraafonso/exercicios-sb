package br.com.beganinha.exerciciossb.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.beganinha.exerciciossb.model.entities.Produto;
import br.com.beganinha.exerciciossb.model.repositories.ProdutoRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

	/*
	 * Essa anotação faz a injeção de dependência e o Inversion of control (IoC)
	 */
	@Autowired
	private ProdutoRepository produtoRepository;

	/**
	 * O Spring consegue instanciar um objeto produto a partir do JSON recebido Isso
	 * só funcionará se as propriedades do JSON forem identicas aos atributos da
	 * entidade
	 * 
	 * @param produto
	 * @return
	 */

	/*
	 * Quando um método JAVA é capaz de atender a dois métodos HTTP, o recomendado é
	 * que se use a anotação @RequestMapping e seja usado o parâmetro method
	 */
//	@PostMapping
	@RequestMapping(method = { RequestMethod.POST, RequestMethod.PUT })
	public @ResponseBody Produto salvarProduto(@Valid Produto produto) {

		produtoRepository.save(produto);

		return produto;
	}

	@GetMapping
	public @ResponseBody Iterable<Produto> getProdutos() {
		Iterable<Produto> produtos = produtoRepository.findAll();

		return produtos;
	}

	/**
	 * Consulta paginada
	 * 
	 * @return
	 */
	@GetMapping(path = "/pagina/{pageNumber}/{quantity}")
	public @ResponseBody Iterable<Produto> getProdutosByPage(@PathVariable int pageNumber, @PathVariable int quantity) {
		Pageable page = PageRequest.of(pageNumber, quantity);
		Iterable<Produto> produtos = produtoRepository.findAll(page);

		return produtos;
	}

	@GetMapping(path = "/{id}")
	public @ResponseBody Optional<Produto> getProdutoById(@PathVariable int id) {

		return produtoRepository.findById(id);
	}

	/**
	 * o deleteById faz um hard delete+
	 * 
	 * @param id
	 */
	@DeleteMapping(path = "/{id}")
	public void deleteProdutoById(@PathVariable int id) {

		produtoRepository.deleteById(id);
	}
	
	@GetMapping(path = "/nome/{partNome}")
	public @ResponseBody Iterable<Produto> getProdutoByName(@PathVariable String partNome) {

		Iterable<Produto> produtos = produtoRepository.findByNomeContaining(partNome);
		
		return produtos;
	}

	@GetMapping(path = "/query/{partNome}")
	public @ResponseBody Iterable<Produto> getProdutoByNameQuery(@PathVariable String partNome) {

		Iterable<Produto> produtos = produtoRepository.searchByNameLike(partNome);
		
		return produtos;
	}


//	@PutMapping
//	public @ResponseBody Produto changeProduto(@Valid Produto produto) {
//		
//		produtoRepository.save(produto);
//		
//		return produto;
//				
//	}
}
