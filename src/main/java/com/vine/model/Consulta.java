package com.vine.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Consulta {
	@Id
	@GeneratedValue
	private Long id;
	
	@ManyToOne(targetEntity = Medico.class)
	@JoinColumn(name = "medico_id")
	@NotNull
	private Medico medico;
	
	@ManyToOne(targetEntity = Atendente.class)
	@JoinColumn(name = "atendente_id")
	@NotNull
	private Atendente atendente;
	
	@ManyToOne(targetEntity = Atendente.class)
	@JoinColumn(name = "paciente_id")
	@NotNull
	private Paciente paciente;
	
	@Column
	@NotNull
	private LocalDateTime dataHora;
	
	@Enumerated(EnumType.STRING)
	@NotNull
	private Status status = Status.A_CONFIRMAR;
	
	// status
	public enum Status {
	    CONFIRMADO,
	    CANCELADO_PELO_USUARIO,
	    CANCELADO_FALTA_CONFIRMACAO,
	    NAO_COMPARECEU,
	    A_CONFIRMAR,
	}
	
	public Consulta(Medico medico, Atendente atendente, Paciente paciente, LocalDateTime dataHora) {
		this.setMedico(medico);
		this.setAtendente(atendente);
		this.setPaciente(paciente);
		this.setDataHora(dataHora);
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Medico getMedico() {
		return medico;
	}
	public void setMedico(Medico medico) {
		this.medico = medico;
	}
	public Atendente getAtendente() {
		return atendente;
	}
	public void setAtendente(Atendente atendente) {
		this.atendente = atendente;
	}
	public Paciente getPaciente() {
		return paciente;
	}
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	public LocalDateTime getDataHora() {
		return dataHora;
	}
	public void setDataHora(LocalDateTime dataHora) {
		this.dataHora = dataHora;
	}
	public Status isStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	
}
