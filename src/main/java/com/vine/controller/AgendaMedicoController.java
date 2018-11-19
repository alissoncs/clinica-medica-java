package com.vine.controller;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vine.dto.AgendaMedicoDTO;
import com.vine.model.AgendaMedico;
import com.vine.model.Medico;
import com.vine.service.AgendaService;
import com.vine.service.MedicoService;

@RestController
public class AgendaMedicoController {
	
	@Autowired
	public MedicoService medicoService;
	
	@Autowired
	public AgendaService agendaService;
	
	@GetMapping("/medicos/{medicoId}/agendas")
	public ResponseEntity<List<AgendaMedicoDTO>> getAgendaMedico(@PathVariable Long medicoId) {
		Medico medico = medicoService.fetchById(medicoId);
		ModelMapper mapper = new ModelMapper();
		
		List<AgendaMedico> agendaBase = agendaService.fetchByMedicoId(medicoId);
		List<AgendaMedicoDTO> dto = new ArrayList<AgendaMedicoDTO>();
		
		for(AgendaMedico i: agendaBase) {
			dto.add(mapper.map(i, AgendaMedicoDTO.class));
		}
		
		return new ResponseEntity<List<AgendaMedicoDTO>>(dto, HttpStatus.OK);
	}
	
	@PostMapping("/medicos/{medicoId}/agendas")
	public ResponseEntity<AgendaMedicoDTO> createAgendaMedico(
			@PathVariable Long medicoId,
			@RequestBody AgendaMedicoDTO agendaDto) throws Exception {
		Medico medico = medicoService.fetchById(medicoId);
		
		System.out.println("Cadastro de agenda: " + agendaDto.toString());
		
		ModelMapper mapper = new ModelMapper();
		AgendaMedico agenda = mapper.map(agendaDto, AgendaMedico.class);
		
		agenda.setMedico(medico);
		agendaService.create(agenda);
		
		// dados para mostrar no resultado
		agendaDto.setId(agenda.getId());
		agendaDto.setMedicoId(medico.getId());
		
		return new ResponseEntity<AgendaMedicoDTO>(agendaDto, HttpStatus.CREATED);
	}
	
}
