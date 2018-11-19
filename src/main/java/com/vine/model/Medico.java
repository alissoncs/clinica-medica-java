package com.vine.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

@Entity
public class Medico {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	@NotBlank
	private String nome;
	
	@Column
	@NotBlank
	private String endereco;
	
	@Column
	@NotBlank
	private String crm;
	
	@Column
	@NotBlank
	private String celular;
	
	@Column
	private String telefone;
	
	@ManyToMany(targetEntity = Especialidade.class)
	@JoinColumn(name = "especialidade_id")
	private List<Especialidade> especialidades;
	
	@OneToMany(targetEntity = AgendaMedico.class)
	private List<AgendaMedico> agendas;
	
	public List<AgendaMedico> getAgendas() {
		return agendas;
	}
	public void setAgendas(List<AgendaMedico> agendas) {
		this.agendas = agendas;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long idMedico) {
		this.id = idMedico;
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
	public List<Especialidade> getEspecialidades() {
		return especialidades;
	}
	public void setEspecialidades(List<Especialidade> especialidades) {
		this.especialidades = especialidades;
	}
}
