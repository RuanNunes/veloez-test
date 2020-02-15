package com.veloez.test.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.veloez.test.contract.TransactionApi;
import com.veloez.test.contract.dto.TransactionDTO;
import com.veloez.test.service.TransactionService;

@RestController
public class TransactionController implements TransactionApi{
	
	@Autowired
	private TransactionService transactionService;

	@Override
	public ResponseEntity<Void> save(@Valid TransactionDTO dto) {
		final var obj = transactionService.save(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
		
	}

	@Override
	public ResponseEntity<TransactionDTO> find(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<List<TransactionDTO>> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<TransactionDTO> update(@Valid TransactionDTO dto, Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
