package com.futurodev.apicrudpessoa.models;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class PessoaModel implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter @Setter
	@EqualsAndHashCode.Include
	public Long id;
	
	@Getter @Setter
	public String nome, email, estado, cidade, logradouro, cep;
	
	@Getter @Setter
	public LocalDate dataNascimento = LocalDate.MIN;
	
	@Getter @Setter
	public LocalTime horaNascimento = LocalTime.MIN;

}
