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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.digitalinnovation.academia.entity.Aluno;
import br.com.digitalinnovation.academia.entity.AvaliacaoFisica;
import br.com.digitalinnovation.academia.entity.DTO.AlunoForm;
import br.com.digitalinnovation.academia.entity.DTO.AlunoUpdateForm;
import br.com.digitalinnovation.academia.service.AlunoService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

	@Autowired
	private AlunoService service;

	/* Cria Aluno usando o form */
	@PostMapping
	public Aluno create(@Valid @RequestBody AlunoForm form) {
		return service.create(form);
	}

	/* Busca a lista alunos pela data de nascimento (se passarmos a data) se não
	 * busca a lista completa
	 */
	@GetMapping
	public List<Aluno> getAll(@RequestParam(value = "dataNascimento", required = false) String dataNascimento) {
		return service.getAll(dataNascimento);
	}

	/* Lista de avaliações fisicas do aluno */
	@GetMapping("/avaliacoes/{id}")
	public List<AvaliacaoFisica> getAllAvaliacaoFisicaId(@PathVariable Long id) {
		return service.getAllAvaliacaoFisicaId(id);
	}
	
	/*Busca o aluno pelo id*/
	@GetMapping("/{id}")
	public Aluno getAlunoById(@PathVariable Long id) {
		return service.get(id);
	}
	
	/*Atualiza cadastro de aluno buscando pelo id*/
	@PatchMapping("/{id}")
	public Aluno updateAluno(@PathVariable Long id , @RequestBody AlunoUpdateForm formUpdate) {
		return service.update(id, formUpdate);
	}
	
	//deleta o aluno pelo id
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		service.delete(id);
	}

}
