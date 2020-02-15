package com.veloez.test.contract;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.veloez.test.contract.dto.UserDTO;

import io.swagger.annotations.ApiOperation;

@RequestMapping("/sessions")
public interface SessionApi 
{
	@ApiOperation(value="login")
	@PostMapping()
	public ResponseEntity<Void> auth(@Valid @RequestBody UserDTO dto);
	
}
