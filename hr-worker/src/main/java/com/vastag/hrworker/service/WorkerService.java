package com.vastag.hrworker.service;

import java.util.List;
import java.util.Optional;

import com.vastag.hrworker.entities.Worker;

public interface WorkerService {
	
	Optional<Worker> findById(Long id);
	
	List<Worker> findAll();

}
