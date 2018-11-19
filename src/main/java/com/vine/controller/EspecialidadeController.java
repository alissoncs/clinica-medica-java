package com.vine.controller;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vine.dto.EspecialidadeDTO;
import com.vine.model.Especialidade;
import com.vine.service.EspecialidadeService;

@RestController
@RequestMapping("/especialidades")
public class EspecialidadeController {
	@Autowired
	public EspecialidadeService service;
	
	@GetMapping
	public ResponseEntity<List<EspecialidadeDTO>> getEspecialidades() {
		List<Especialidade> esp = service.fetchAll();
		List<EspecialidadeDTO> dto = new ArrayList<EspecialidadeDTO>();
		
		ModelMapper mapper = new ModelMapper();
		
		for(Especialidade e: esp) {
			dto.add(mapper.map(e, EspecialidadeDTO.class));
		}
		
		return new ResponseEntity<List<EspecialidadeDTO>>(dto, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<EspecialidadeDTO> createEspecialidades(
			@RequestBody EspecialidadeDTO especialideDto) throws Exception {
		ModelMapper mapper = new ModelMapper();
		Especialidade especialidade = mapper.map(especialideDto, Especialidade.class);
		
		service.create(especialidade);
		
		especialideDto.setId(especialidade.getId());
		
		return new ResponseEntity<EspecialidadeDTO>(especialideDto, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteEspecialidade(@PathVariable Long id) throws Exception {
		Especialidade especialidade = service.fetchById(id);
		service.delete(especialidade);
		
		return new ResponseEntity<Object>(null, HttpStatus.ACCEPTED);
	}
	
}
