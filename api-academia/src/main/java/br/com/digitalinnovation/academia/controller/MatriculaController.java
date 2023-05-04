package br.com.digitalinnovation.academia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.digitalinnovation.academia.entity.Matricula;
import br.com.digitalinnovation.academia.entity.DTO.MatriculaForm;
import br.com.digitalinnovation.academia.service.MatriculaService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/matriculas")
public class MatriculaController {
	
	@Autowired
	private MatriculaService service;
	
	/*Criando matricula*/
	@PostMapping
	public Matricula create(@Valid @RequestBody MatriculaForm form) {
		return service.create(form);
	}

	/*Buscando matriculas por bairro*/
	@GetMapping
	public List<Matricula> getAll(@RequestParam(value = "bairro", required = false) String bairro){
		return service.getAll(bairro);
	}
	
	/*Busca a matricula pelo id*/
	@GetMapping("/{id}")
	public Matricula findByI(@PathVariable Long id) {
		return service.get(id);
	}
	
	/*deleta a matricula com base no id*/
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		service.delete(id);
	}

}
