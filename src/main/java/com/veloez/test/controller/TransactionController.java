package com.veloez.test.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;

import com.veloez.test.contract.TransactionApi;
import com.veloez.test.contract.dto.TransactionDTO;

public class TransactionController implements TransactionApi{

	@Override
	public ResponseEntity<?> findPaginate(@Valid TransactionDTO filters) {
		return null;
	}

	@Override
	public ResponseEntity<Void> save(@Valid TransactionDTO dto) {
		
		return null;
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
