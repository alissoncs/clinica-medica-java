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
import com.vine.model.Especialidade;
import com.vine.model.Medico;
import com.vine.service.EspecialidadeService;
import com.vine.service.MedicoService;

@RestController
@RequestMapping("/medicos")
public class MedicoController {
	
	@Autowired
	public MedicoService service;
	
	@Autowired
	public EspecialidadeService especialidadeService;
	
	@GetMapping
	public ResponseEntity<List<MedicoDTO>> getMedicos() {
		List<Medico> medicos = service.fetchAll(); 
		System.out.println("List medicos, Count: " + medicos.size());
		ModelMapper mapper = new ModelMapper();
		
		List<MedicoDTO> dtoList = new ArrayList<MedicoDTO>();
		for(Medico i: medicos) {
			MedicoDTO dtoItem = mapper.map(i, MedicoDTO.class);
			if (i.getEspecialidades() != null) {
				for(Especialidade e: i.getEspecialidades()) {
					dtoItem.getEspecialidadesIds().add(e.getId());
				}
			}
			dtoList.add(dtoItem);
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
	public ResponseEntity<MedicoDTO> createMedico(@RequestBody MedicoDTO medicoDto) throws Exception {
		ModelMapper mapper = new ModelMapper();
		Medico medico = mapper.map(medicoDto, Medico.class);
		
		if (medicoDto.getEspecialidadesIds() != null) {
			List<Especialidade> especs = new ArrayList<Especialidade>();
			List<Long> idsEspecialidades = new ArrayList<Long>();
			for (Long idEspecialidade: medicoDto.getEspecialidadesIds()) {
				if (especialidadeService.exists(idEspecialidade)) {
					Especialidade e = especialidadeService.fetchById(idEspecialidade);
					especs.add(e);
					idsEspecialidades.add(idEspecialidade);
				}
			}
			medicoDto.setEspecialidadeIds(idsEspecialidades);
			medico.setEspecialidades(especs);
		}
		
		System.out.println("Create Medico, " + medico.toString());
		service.create(medico);
		medicoDto.setId(medico.getId());
		
		return new ResponseEntity<MedicoDTO>(medicoDto, HttpStatus.CREATED);
	}
}
