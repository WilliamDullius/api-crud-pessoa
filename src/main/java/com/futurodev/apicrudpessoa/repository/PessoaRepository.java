package com.futurodev.apicrudpessoa.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.futurodev.apicrudpessoa.models.PessoaModel;

public interface PessoaRepository extends JpaRepository<PessoaModel, Long> {
	
	@Query ("select buscaNomePessoa from PessoaModel buscaNomePessoa where buscaNomePessoa.nome like %?1%")
	ArrayList<PessoaModel> getPessoaByName (String nome);

}
