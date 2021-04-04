package com.vastag.hrpayroll.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PaymentDTO {

	private String name;
	private Double dailyIncome;
	private Integer days;

	public double getTotal() {
		return days * dailyIncome;
	}
}