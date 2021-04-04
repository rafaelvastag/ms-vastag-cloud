package com.vastag.hrpayroll.services;

import java.util.Optional;

import com.vastag.hrpayroll.entities.Payment;

public interface PaymentService {

	public Optional<Payment> getPayment(Long workerId, int days);

}
