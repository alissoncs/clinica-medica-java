package com.vine.controller;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vine.dto.AtendenteDTO;
import com.vine.dto.AtendenteDTO;
import com.vine.model.Atendente;
import com.vine.service.AtendenteService;

@RestController
@RequestMapping("/atendentes")
public class AtendenteController {

	public AtendenteService service;
	
	@GetMapping
	public ResponseEntity<List<AtendenteDTO>> getAtendentes() {
		ModelMapper mapper = new ModelMapper();
		
		List<Atendente> Atendentes = service.fetchAll(); 
		System.out.println("List Atendentes, Count: " + Atendentes.size());
		
		List<AtendenteDTO> dtoList = new ArrayList<AtendenteDTO>();
		for(Atendente i: Atendentes) {
			dtoList.add(mapper.map(i, AtendenteDTO.class));
		}
		return new ResponseEntity<List<AtendenteDTO>>(dtoList, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<AtendenteDTO> getAtendente(@PathVariable Long id) {
		Atendente atendente = service.fetchById(id);
		
		System.out.println("Get Atendente, ID: " + id);
		ModelMapper mapper = new ModelMapper();
		AtendenteDTO dto = mapper.map(atendente, AtendenteDTO.class);
		
		return new ResponseEntity<AtendenteDTO>(dto, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Atendente> createMedico(@RequestBody AtendenteDTO atendenteDto) throws Exception {
		ModelMapper mapper = new ModelMapper();
		Atendente Atendente = mapper.map(atendenteDto, Atendente.class);
		
		System.out.println("Create Atendente, " + Atendente.toString());
		service.create(Atendente);
		
		return new ResponseEntity<Atendente>(Atendente, HttpStatus.CREATED);
	}
	
}
