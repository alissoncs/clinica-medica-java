package com.vine.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vine.service.ConsultaService;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {
	@Autowired
	private ConsultaService consultaService;
	
	@Autowired
	private MedicoService medicoService;
	
	@GetMapping
	public ResponseEntity<Object> getConsultas() {
		
	}
}
