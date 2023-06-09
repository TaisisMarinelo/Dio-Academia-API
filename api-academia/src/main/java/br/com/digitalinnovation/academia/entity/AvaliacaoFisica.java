package br.com.digitalinnovation.academia.entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_avaliacoes")
public class AvaliacaoFisica {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "aluno_id")
	private Aluno aluno;
	
	private LocalDateTime dataAvaliacao = LocalDateTime.now();
	
	@Column(name="peso_atual")
	private double peso;
	
	@Column(name="altura_atual")
	private double altura;

}
