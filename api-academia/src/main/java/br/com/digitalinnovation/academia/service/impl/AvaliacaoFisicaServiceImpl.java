package br.com.digitalinnovation.academia.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.digitalinnovation.academia.entity.Aluno;
import br.com.digitalinnovation.academia.entity.AvaliacaoFisica;
import br.com.digitalinnovation.academia.entity.DTO.AvaliacaoFisicaForm;
import br.com.digitalinnovation.academia.entity.DTO.AvaliacaoFisicaUpdateForm;
import br.com.digitalinnovation.academia.repository.AlunoRepository;
import br.com.digitalinnovation.academia.repository.AvaliacaoFisicaRepository;
import br.com.digitalinnovation.academia.service.AvaliacaoFisicaService;

@Service
public class AvaliacaoFisicaServiceImpl implements AvaliacaoFisicaService {

	@Autowired
	private AvaliacaoFisicaRepository avaliacaoFisicaRepository;

	@Autowired
	private AlunoRepository alunoRepository;

	@Override
	public AvaliacaoFisica create(AvaliacaoFisicaForm form) {

		AvaliacaoFisica avaliacaoFisica = new AvaliacaoFisica();
		Aluno aluno = alunoRepository.findById(form.getAlunoId()).get();
		avaliacaoFisica.setAluno(aluno);
		avaliacaoFisica.setPeso(form.getPeso());
		avaliacaoFisica.setAltura(form.getAltura());
		return avaliacaoFisicaRepository.save(avaliacaoFisica);
	}

	@Override
	public AvaliacaoFisica get(Long id) {
		AvaliacaoFisica avaliacao = avaliacaoFisicaRepository.findById(id).get();
		return avaliacao;
	}

	@Override
	public List<AvaliacaoFisica> getAll() {

		return avaliacaoFisicaRepository.findAll();
	}

	@Override
	public AvaliacaoFisica update(Long id, AvaliacaoFisicaUpdateForm formUpdate) {
		AvaliacaoFisica avaliacaoUpdate =  avaliacaoFisicaRepository.findById(id).get();
		avaliacaoUpdate.setPeso(formUpdate.getPeso());
		avaliacaoUpdate.setAltura(formUpdate.getAltura());
		return avaliacaoFisicaRepository.save(avaliacaoUpdate);
	}

	@Override
	public void delete(Long id) {
		avaliacaoFisicaRepository.deleteById(id);
	}

}
