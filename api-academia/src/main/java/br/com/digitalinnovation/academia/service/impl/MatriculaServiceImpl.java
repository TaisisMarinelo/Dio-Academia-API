package br.com.digitalinnovation.academia.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.digitalinnovation.academia.entity.Aluno;
import br.com.digitalinnovation.academia.entity.Matricula;
import br.com.digitalinnovation.academia.entity.DTO.MatriculaForm;
import br.com.digitalinnovation.academia.repository.AlunoRepository;
import br.com.digitalinnovation.academia.repository.MatriculaRepository;
import br.com.digitalinnovation.academia.service.MatriculaService;

@Service
public class MatriculaServiceImpl implements MatriculaService {
	
	 @Autowired
	  private MatriculaRepository matriculaRepository;

	  @Autowired
	  private AlunoRepository alunoRepository;

	  @Override
	  public Matricula create(MatriculaForm form) {
	    Matricula matricula = new Matricula();
	    Aluno aluno = alunoRepository.findById(form.getAlunoId()).get();

	    matricula.setAluno(aluno);

	    return matriculaRepository.save(matricula);
	  }

	  @Override
	  public Matricula get(Long id) {
		  Matricula matricula = matriculaRepository.findById(id).get();
	    return matricula;
	  }

	  @Override
	  public List<Matricula> getAll(String bairro) {

	    if(bairro == null){
	      return matriculaRepository.findAll();
	    }else{
	      return matriculaRepository.findAlunosMatriculadosBairro(bairro);
	    }

	  }

	  @Override
	  public void delete(Long id) {
		  matriculaRepository.deleteById(id);
	  }


}
