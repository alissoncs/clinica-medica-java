package com.vine.dto;

import java.time.LocalDateTime;

public class AgendaMedicoDTO {
	private Long medicoId;
	private Long id;
	private LocalDateTime dataHora;
	private LocalDateTime dataHoraFim;
	
	public LocalDateTime getDataHora() {
		return dataHora;
	}
	public void setDataHora(LocalDateTime dataHora) {
		this.dataHora = dataHora;
	}
	public Long getMedicoId() {
		return medicoId;
	}
	public void setMedicoId(Long medicoId) {
		this.medicoId = medicoId;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String toString() {
		return "id: " + this.getId() +
				", medicoId: " + this.getMedicoId() +
				", dataHora: " + (this.getDataHora() != null ? this.getDataHora().toString() : "null");
	}
	
}
