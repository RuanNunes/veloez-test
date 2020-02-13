package com.veloez.test.contract.dto;

import javax.validation.constraints.NotNull;

import com.veloez.test.model.Classe;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder
public class TransactionDTO {
	
	@NotNull
	private String name;

	@NotNull
	private String payloadReq;
	@NotNull
	private String payloadRes;
	@NotNull
	private Classe classe;
	
	private String error;

}
