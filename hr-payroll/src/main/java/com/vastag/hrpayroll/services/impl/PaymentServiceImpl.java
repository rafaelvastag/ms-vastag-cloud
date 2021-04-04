package com.vastag.hrpayroll.services.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.vastag.hrpayroll.dto.WorkerDTO;
import com.vastag.hrpayroll.entities.Payment;
import com.vastag.hrpayroll.feignclients.WorkerFeignClient;
import com.vastag.hrpayroll.services.PaymentService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

	private final WorkerFeignClient workerFeign;

	@Override
	public Optional<Payment> getPayment(Long workerId, int days) {
		WorkerDTO worker = workerFeign.findByWorkerId(workerId).getBody();
		
		return Optional
				.of(Payment.builder().name(worker.getName()).dailyIncome(worker.getDailyIncome()).days(days).build());
	}

}
