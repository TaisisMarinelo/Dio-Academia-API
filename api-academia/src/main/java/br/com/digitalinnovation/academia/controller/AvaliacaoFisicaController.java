package br.com.digitalinnovation.academia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.digitalinnovation.academia.entity.AvaliacaoFisica;
import br.com.digitalinnovation.academia.entity.DTO.AvaliacaoFisicaForm;
import br.com.digitalinnovation.academia.entity.DTO.AvaliacaoFisicaUpdateForm;
import br.com.digitalinnovation.academia.service.AvaliacaoFisicaService;

@RestController
@RequestMapping("/avaliacoes")
public class AvaliacaoFisicaController {
	
		@Autowired
	private AvaliacaoFisicaService service;
	
	/*Criando avaliacao fisica*/
	@PostMapping
	public AvaliacaoFisica create(@RequestBody AvaliacaoFisicaForm form) {
		return service.create(form);
	}
	
	
	/*Buscando todas as avaliacoes*/
	@GetMapping
	public List<AvaliacaoFisica> getAll(){
		return service.getAll();
	}
	
	/*Busca a avaliação pelo is*/
	@GetMapping("/{id}")
	public AvaliacaoFisica getByID(@PathVariable Long id){
		return service.get(id);
	}
	
	/*Atualiza as infos pelo id*/
	@PatchMapping("{id}")
	public AvaliacaoFisica update(@PathVariable Long id, @RequestBody AvaliacaoFisicaUpdateForm formaUpdate) {
		return service.update(id, formaUpdate);
	}
	
	/*Deletando avaliação fisica*/
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		service.delete(id);
	}
}
