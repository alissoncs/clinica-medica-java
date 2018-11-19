package com.vine.controller;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vine.dto.MedicoDTO;
import com.vine.model.Medico;
import com.vine.service.MedicoService;

@RestController
@RequestMapping("/medicos")
public class MedicoController {
	
	@Autowired
	public MedicoService service;
	
	@GetMapping
	public ResponseEntity<List<MedicoDTO>> getMedicos() {
		List<Medico> medicos = service.fetchAll(); 
		System.out.println("List medicos, Count: " + medicos.size());
		ModelMapper mapper = new ModelMapper();
		
		List<MedicoDTO> dtoList = new ArrayList<MedicoDTO>();
		for(Medico i: medicos) {
			dtoList.add(mapper.map(i, MedicoDTO.class));
		}
		return new ResponseEntity<List<MedicoDTO>>(dtoList, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<MedicoDTO> getMedico(@PathVariable Long id) {
		Medico medico = service.fetchById(id);
		
		System.out.println("Get Medico, ID: " + id);
		ModelMapper mapper = new ModelMapper();
		MedicoDTO m = mapper.map(medico, MedicoDTO.class);
		return new ResponseEntity<MedicoDTO>(m, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Medico> createMedico(@RequestBody MedicoDTO medicoDto) throws Exception {
		ModelMapper mapper = new ModelMapper();
		Medico m = mapper.map(medicoDto, Medico.class);
		
		System.out.println("Create Medico, " + m.toString());
		service.create(m);
		
		return new ResponseEntity<Medico>(m, HttpStatus.CREATED);
	}
}
