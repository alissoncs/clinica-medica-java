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

import com.vine.dto.MedicoDTO;
import com.vine.dto.PacienteDTO;
import com.vine.model.Medico;
import com.vine.model.Paciente;
import com.vine.service.PacienteService;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {
	
	@Autowired
	public PacienteService service;
	
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
	
	@PostMapping
	public ResponseEntity<Paciente> createMedico(@RequestBody PacienteDTO pacienteDto) throws Exception {
		ModelMapper mapper = new ModelMapper();
		Paciente paciente = mapper.map(pacienteDto, Paciente.class);
		
		System.out.println("Create Paciente, " + paciente.toString());
		service.create(paciente);
		
		return new ResponseEntity<Paciente>(paciente, HttpStatus.CREATED);
	}
}
