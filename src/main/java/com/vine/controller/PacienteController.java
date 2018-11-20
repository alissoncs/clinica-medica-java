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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vine.dto.ConsultaDTO;
import com.vine.dto.PacienteDTO;
import com.vine.model.Consulta;
import com.vine.model.Medico;
import com.vine.model.Paciente;
import com.vine.service.ConsultaService;
import com.vine.service.PacienteService;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {
	
	@Autowired
	public PacienteService service;
	
	@Autowired
	public ConsultaService consultaService;
	
	@GetMapping
	public ResponseEntity<List<PacienteDTO>> getPacientes() {
		ModelMapper mapper = new ModelMapper();
		
		List<Paciente> pacientes = service.fetchAll(); 
		System.out.println("List pacientes, Count: " + pacientes.size());
		
		List<PacienteDTO> dtoList = new ArrayList<PacienteDTO>();
		for(Paciente i: pacientes) {
			dtoList.add(mapper.map(i, PacienteDTO.class));
		}
		return new ResponseEntity<List<PacienteDTO>>(dtoList, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<PacienteDTO> getPaciente(@PathVariable Long id) {
		Paciente paciente = service.fetchById(id);
		
		System.out.println("Get Paciente, ID: " + id);
		ModelMapper mapper = new ModelMapper();
		PacienteDTO dto = mapper.map(paciente, PacienteDTO.class);
		
		return new ResponseEntity<PacienteDTO>(dto, HttpStatus.OK);
	}
	
	@GetMapping("/{id}/consultas")
	public ResponseEntity<List<ConsultaDTO>> getConsultas(@PathVariable Long id) throws Exception {
		// verifica se o paciente existe na base
		service.fetchById(id);
		
		ModelMapper mapper = new ModelMapper();
		
		// carrega consultas por paciente id
		List<Consulta> consultas = consultaService.fetchByPacienteId(id);
		
		// converter para DTO
		List<ConsultaDTO> dtoList = new ArrayList<ConsultaDTO>();
		for(Consulta c: consultas) {
			ConsultaDTO dto = mapper.map(c, ConsultaDTO.class);
			dtoList.add(dto);
		}
		
		return new ResponseEntity<List<ConsultaDTO>>(dtoList, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<PacienteDTO> createPaciente(@RequestBody PacienteDTO pacienteDto) throws Exception {
		ModelMapper mapper = new ModelMapper();
		// converte de DTO para hibernate entity
		Paciente paciente = mapper.map(pacienteDto, Paciente.class);
		
		System.out.println("Create Paciente, " + paciente.toString());
		
		// salvar
		service.create(paciente);
		pacienteDto.setId(paciente.getId());
		
		// retorna o mesmo objeto
		return new ResponseEntity<PacienteDTO>(pacienteDto, HttpStatus.CREATED);
	}
}
