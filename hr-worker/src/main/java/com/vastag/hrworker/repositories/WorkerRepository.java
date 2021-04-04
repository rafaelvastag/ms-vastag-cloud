package com.vastag.hrworker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vastag.hrworker.entities.Worker;

public interface WorkerRepository extends JpaRepository<Worker, Long> {

}
