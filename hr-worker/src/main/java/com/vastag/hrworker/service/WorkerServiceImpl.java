package com.vastag.hrworker.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.vastag.hrworker.entities.Worker;
import com.vastag.hrworker.repositories.WorkerRepository;

@Service
public class WorkerServiceImpl implements WorkerService{
	
	private WorkerRepository repository;

	public WorkerServiceImpl(WorkerRepository repository) {
		this.repository = repository;
	}

	@Override
	public Optional<Worker> findById(Long id) {
		return repository.findById(id);
	}

	@Override
	public List<Worker> findAll() {
		return repository.findAll();
	}
	
	
	
}
