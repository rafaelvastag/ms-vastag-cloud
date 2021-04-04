package com.vastag.hrworker.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.vastag.hrworker.dto.WorkerDTO;
import com.vastag.hrworker.service.WorkerService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value = "/workers")
@RequiredArgsConstructor
@Slf4j
public class WorkerResource {

	private final WorkerService service;
	private final ModelMapper modelMapper;
	
	@Autowired
	private Environment env;

	@GetMapping
	public ResponseEntity<List<WorkerDTO>> findAll() {
		List<WorkerDTO> list = service.findAll().stream().map(entity -> modelMapper.map(entity, WorkerDTO.class))
				.collect(Collectors.toList());
		return ResponseEntity.ok(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<WorkerDTO> findByWorkerId(@PathVariable(name = "id") Long id) {
		
		log.info("PORT = " + env.getProperty("local.server.port"));
		
		WorkerDTO worker = service.findById(id).map(entity -> modelMapper.map(entity, WorkerDTO.class))
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
		return ResponseEntity.ok(worker);
	}

}
