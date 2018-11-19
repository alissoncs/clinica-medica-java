package com.vine.dto;

import java.util.List;

public class MedicoDTO {
	
	private Long id;
	private String nome;
	private String endereco;
	private String crm;
	private String celular;
	private String telefone;
	private List<Long> especialidades;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getCrm() {
		return crm;
	}
	public void setCrm(String crm) {
		this.crm = crm;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public List<Long> getEspecialidades() {
		return especialidades;
	}
	public void setEspecialidades(List<Long> especialidades) {
		this.especialidades = especialidades;
	}
}
