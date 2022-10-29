package com.futurodev.apicrudpessoa.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.futurodev.apicrudpessoa.models.PessoaModel;
import com.futurodev.apicrudpessoa.repository.PessoaRepository;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {
	
	@Autowired
	public PessoaRepository pessoaRepository;
	
	@PostMapping("/criarPessoa")
	public ResponseEntity<PessoaModel> criarPessoa (@RequestBody PessoaModel novaPessoa){
		PessoaModel retorno = pessoaRepository.save(novaPessoa);
		return new ResponseEntity<PessoaModel>(retorno, HttpStatus.CREATED);
	}
	
	@GetMapping("/buscarPessoa") //BUSCA PESSOA PELO id REQUISITADO NO BODY DA REQUISIÇÃO
	public ResponseEntity<PessoaModel> buscarPessoa (@RequestParam Long id){
		PessoaModel retorno = pessoaRepository.findById(id).get();
		return new ResponseEntity<PessoaModel>(retorno, HttpStatus.OK);
	}
	
	@PutMapping("/atualizarPessoa")
	public ResponseEntity<PessoaModel> atualizarContato(@RequestBody PessoaModel updatePessoa){
		PessoaModel retorno = pessoaRepository.save(updatePessoa);
		return new ResponseEntity<PessoaModel>(retorno, HttpStatus.OK);
	}
	
	@DeleteMapping("/deletePessoa")
	public ResponseEntity<String> deletarPessoa(@RequestParam Long id){
		pessoaRepository.deleteById(id);
		return new ResponseEntity<String>("Deletado com Sucesso!", HttpStatus.OK);	
	}	
	
	@GetMapping("/buscarPorNome")
	public ResponseEntity<List<PessoaModel>> buscaPessoaByName (@RequestParam String nome){
		List<PessoaModel> retorno = pessoaRepository.getPessoaByName(nome);
		return new ResponseEntity<List<PessoaModel>>(retorno, HttpStatus.OK);
	}
}
