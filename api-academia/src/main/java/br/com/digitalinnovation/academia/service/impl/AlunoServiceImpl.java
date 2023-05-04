package br.com.digitalinnovation.academia.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.digitalinnovation.academia.entity.Aluno;
import br.com.digitalinnovation.academia.entity.AvaliacaoFisica;
import br.com.digitalinnovation.academia.entity.DTO.AlunoForm;
import br.com.digitalinnovation.academia.entity.DTO.AlunoUpdateForm;
import br.com.digitalinnovation.academia.infra.util.JavaTimeUtils;
import br.com.digitalinnovation.academia.repository.AlunoRepository;
import br.com.digitalinnovation.academia.service.AlunoService;

@Service
public class AlunoServiceImpl implements AlunoService{

	  @Autowired
	  private AlunoRepository repository;

	  @Override
	  public Aluno create(AlunoForm form) {
	    Aluno aluno = new Aluno();
	    aluno.setNome(form.getNome());
	    aluno.setCpf(form.getCpf());
	    aluno.setBairro(form.getBairro());
	    aluno.setDataNascimento(form.getDataNascimento());

	    return repository.save(aluno);
	  }

		@Override
		public Aluno get(Long id) {
			Aluno aluno = repository.findById(id).get();

			return aluno;
		}

	  @Override
	  public List<Aluno> getAll(String dataDeNascimento) {

	    if(dataDeNascimento == null) {
	      return repository.findAll();
	    } else {
	      LocalDate localDate = LocalDate.parse(dataDeNascimento, JavaTimeUtils.LOCAL_DATE_FORMATTER);
	      return repository.findByDataNascimento(localDate);
	    }

	  }

	  @Override
	  public Aluno update(Long id, AlunoUpdateForm formUpdate) {
		  Aluno alunoAtualizado = repository.findById(id).get();
		  
		  alunoAtualizado.setNome(formUpdate.getNome());
		  alunoAtualizado.setBairro(formUpdate.getBairro());
		  alunoAtualizado.setDataNascimento(formUpdate.getDataNascimento());
		  
	    return repository.save(alunoAtualizado);
	  }

	  @Override
	  public void delete(Long id) {
		 repository.deleteById(id);
	  }

	  @Override
	  public List<AvaliacaoFisica> getAllAvaliacaoFisicaId(Long id) {

	    Aluno aluno = repository.findById(id).get();

	    return aluno.getAvaliacao();

	  }

}
