package com.veloez.test.contract.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TokenDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	private UserDTO user;
	private String token;	

}