package com.vastag.hrpayroll.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WorkerDTO {

	private Long id;
	private String name;
	private Double dailyIncome;

}
