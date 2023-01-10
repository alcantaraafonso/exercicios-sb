package br.com.beganinha.exerciciossb.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.beganinha.exerciciossb.model.entities.Produto;
import br.com.beganinha.exerciciossb.model.repositories.ProdutoRepository;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {
	
	/*
	 * Essa anotação faz a injeção de dependência e o Inversion of control (IoC)
	 */
	@Autowired
	private ProdutoRepository produtoRepository;

	/**
	 * O Spring consegue instanciar um objeto produto a partir do JSON recebido
	 * Isso só funcionará se as propriedades do JSON forem identicas aos atributos da entidade
	 * @param produto
	 * @return
	 */
	@PostMapping
	public @ResponseBody Produto novoProduto(Produto produto) {
		
		produtoRepository.save(produto);
		
		return produto;
	}
	
}
