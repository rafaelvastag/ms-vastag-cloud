package com.vastag.hrpayroll.services;

import com.vastag.hrpayroll.entities.Payment;

public interface PaymentService {

	public Payment getPayment(Long workerId, int days);

}
