package com.veloez.test.contract.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//TODO Passar file junto no post
	@NotNull
	private String avatarUrl;
		
	@NotNull
	private String name;
		
	@NotNull
	private String email;
	@NotNull
	private String password;
	
	@NotNull
	private String cpf;
	
	@NotNull
	private BigDecimal balance;
	
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss.SSS")
	private LocalDateTime created;

	@JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss.SSS")
	private LocalDateTime updated;

}
