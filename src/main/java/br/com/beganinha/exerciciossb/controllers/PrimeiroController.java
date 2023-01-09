package br.com.beganinha.exerciciossb.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class PrimeiroController {

	/*
	 * O método HTTP padrão essa anotação é GET
	 */
	@RequestMapping(method = RequestMethod.GET, path = "/ola")
	public String ola() {
		return "Olá Spring Boot";
	}
	
	
	@GetMapping
	public String olaGet() {
		return "Olá Spring Boot - raiz";
	}
	
	@PostMapping
	public String olaPost() {
		return "Olá Spring Boot - raiz (post)";
	}
}
