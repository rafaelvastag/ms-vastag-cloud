package com.vastag.hrpayroll.services.impl;

import org.springframework.stereotype.Service;

import com.vastag.hrpayroll.entities.Payment;
import com.vastag.hrpayroll.services.PaymentService;

@Service
public class PaymentServiceImpl implements PaymentService{

	@Override
	public Payment getPayment(Long workerId, int days) {
		return Payment.builder().name("Bob").dailyIncome(200.0).days(days).build();
	}

}
