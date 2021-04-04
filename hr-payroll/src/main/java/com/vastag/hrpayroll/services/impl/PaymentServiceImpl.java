package com.vastag.hrpayroll.services.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.vastag.hrpayroll.dto.WorkerDTO;
import com.vastag.hrpayroll.entities.Payment;
import com.vastag.hrpayroll.services.PaymentService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

	private final RestTemplate restTemplate;

	@Value("${hr-worker.host}")
	private String workerHost;

	@Override
	public Optional<Payment> getPayment(Long workerId, int days) {
		Map<String, String> uriVariables = new HashMap<String, String>();
		uriVariables.put("id", "" + workerId);

		WorkerDTO worker = restTemplate.getForObject(workerHost + "/workers/{id}", WorkerDTO.class, uriVariables);

		return Optional
				.of(Payment.builder().name(worker.getName()).dailyIncome(worker.getDailyIncome()).days(days).build());
	}

}
