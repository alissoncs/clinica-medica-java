package com.vine.dto;

import java.time.LocalDateTime;

import com.vine.model.Consulta.Status;

public class ConsultaDTO {
	private Long id;
	private Long atendenteId;
	private Long medicoId;
	private Long pacienteId;
	private LocalDateTime dataHora;
	private Status status;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getAtendenteId() {
		return atendenteId;
	}
	public void setAtendenteId(Long atendenteId) {
		this.atendenteId = atendenteId;
	}
	public Long getMedicoId() {
		return medicoId;
	}
	public void setMedicoId(Long medicoId) {
		this.medicoId = medicoId;
	}
	public Long getPacienteId() {
		return pacienteId;
	}
	public void setPacienteId(Long pacienteId) {
		this.pacienteId = pacienteId;
	}
	public LocalDateTime getDataHora() {
		return dataHora;
	}
	public void setDataHora(LocalDateTime dataHora) {
		this.dataHora = dataHora;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
}
