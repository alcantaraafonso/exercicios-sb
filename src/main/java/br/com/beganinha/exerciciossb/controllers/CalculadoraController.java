package br.com.beganinha.exerciciossb.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculadora")
public class CalculadoraController {

	// /calculadora/somar/10/20
	@GetMapping("/somar/{a}/{b}")
	public double somar(@PathVariable double a, @PathVariable double b) {
		return a + b;
	}
	
	// /calculadora/subtrair?a=10&b=20
	@GetMapping("/subtrair")
	public double subtrair(
			@RequestParam(name = "a") double a, 
			@RequestParam(name = "b") double b) {
		return a - b;
	}
}
