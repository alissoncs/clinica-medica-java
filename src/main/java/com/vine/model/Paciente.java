package com.vine.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Paciente {
	@Id
	@GeneratedValue
	private Long id;
	
	@Column
	@NotBlank
	private String nome;
	
	@Column
	@NotBlank
	private String cpf;
	@Column
	@NotBlank
	private String rg;
	@Column
	private String telefone;
	
	@Column
	@NotBlank
	private String celular;
	
	@Column
	@NotBlank
	private String endereco;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long idPaciente) {
		this.id = idPaciente;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
}
