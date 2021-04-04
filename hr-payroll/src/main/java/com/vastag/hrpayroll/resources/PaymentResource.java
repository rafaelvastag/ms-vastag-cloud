package com.vastag.hrpayroll.resources;

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

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.vastag.hrpayroll.dto.PaymentDTO;
import com.vastag.hrpayroll.services.PaymentService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value = "/payments")
@RequiredArgsConstructor
@Slf4j
public class PaymentResource {

	private final PaymentService service;
	private final ModelMapper modelMapper;
	
	@Autowired
	private Environment env;

	@HystrixCommand(fallbackMethod = "getPaymentFallback")
	@GetMapping(value = "/{workerId}/days/{days}")
	public ResponseEntity<PaymentDTO> getPayment(@PathVariable Long workerId, @PathVariable Integer days) {
		
		log.info("PORT = " + env.getProperty("local.server.port"));
		return ResponseEntity
				.ok(service.getPayment(workerId, days).map(payment -> modelMapper.map(payment, PaymentDTO.class))
						.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)));
	}

	public ResponseEntity<PaymentDTO> getPaymentFallback(Long workerId, Integer days) {
		return ResponseEntity.ok(PaymentDTO.builder()
				.name("DEFAULT_WORKER").dailyIncome(100.0).days(30)
				.build());
	}

}
