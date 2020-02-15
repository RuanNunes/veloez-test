package com.veloez.test.contract.dto;

import java.util.Map;

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
	
	private Long id;
	
	@NotNull
	private String name;

	@NotNull
	private Map<String, Object> payloadReq;
	@NotNull
	private Map<String, Object> payloadRes;
	@NotNull
	private Classe classe;
	
	private String error;

}
