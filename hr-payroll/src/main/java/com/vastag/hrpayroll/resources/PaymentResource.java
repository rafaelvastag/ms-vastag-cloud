package com.vastag.hrpayroll.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vastag.hrpayroll.entities.Payment;
import com.vastag.hrpayroll.services.PaymentService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "/payments")
@RequiredArgsConstructor
public class PaymentResource {

	private final PaymentService service;

	@GetMapping(value = "/{workerId}/days/{days}")
	public ResponseEntity<Payment> getPayment(@PathVariable Long workerId, @PathVariable Integer days) {
		return ResponseEntity.ok(service.getPayment(workerId, days));
	}

}
