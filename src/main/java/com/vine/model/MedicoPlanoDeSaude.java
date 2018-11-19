package com.vine.model;

public class MedicoPlanoDeSaude {
	private Long id;
	private Medico medico;
	private PlanoDeSaude planoDeSaude;
	private Paciente paciente;
	
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
	public PlanoDeSaude getPlanoDeSaude() {
		return planoDeSaude;
	}
	public void setPlanoDeSaude(PlanoDeSaude planoDeSaude) {
		this.planoDeSaude = planoDeSaude;
	}
	public Paciente getPaciente() {
		return paciente;
	}
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
}
