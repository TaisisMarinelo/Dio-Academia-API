package br.com.digitalinnovation.academia.entity.DTO;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AlunoUpdateForm {
	
	private String nome;
	private String bairro;
	private LocalDate dataNascimento;

}
