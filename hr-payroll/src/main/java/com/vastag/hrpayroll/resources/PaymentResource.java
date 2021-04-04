package com.vastag.hrpayroll.resources;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.vastag.hrpayroll.dto.PaymentDTO;
import com.vastag.hrpayroll.services.PaymentService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "/payments")
@RequiredArgsConstructor
public class PaymentResource {

	private final PaymentService service;
	private final ModelMapper modelMapper;

	@GetMapping(value = "/{workerId}/days/{days}")
	public ResponseEntity<PaymentDTO> getPayment(@PathVariable Long workerId, @PathVariable Integer days) {
		return ResponseEntity
				.ok(service.getPayment(workerId, days).map(payment -> modelMapper.map(payment, PaymentDTO.class))
						.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)));
	}

}
