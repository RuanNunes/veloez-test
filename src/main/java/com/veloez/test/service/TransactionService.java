package com.veloez.test.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.veloez.test.contract.dto.TransactionDTO;
import com.veloez.test.contract.dto.UserDTO;
import com.veloez.test.mapper.TransactionMapper;
import com.veloez.test.model.Classe;
import com.veloez.test.model.Transaction;
import com.veloez.test.repository.TransactionRepository;

@Service
public class TransactionService implements GenericService<TransactionDTO, TransactionDTO>{
	
	@Autowired
	private TransactionRepository transactionRepository;
	
	@Autowired
	private TransactionMapper mapper;
	
	@Autowired
	private UserServiceApi userServiceApi;
		
	@Override
	public TransactionDTO save(TransactionDTO dto) {
		if (Classe.USER.equals(dto.getClasse())) {
			final var responseUsers = userServiceApi.saveMany(12);
			final Map<String, Object> req = new HashMap<>();
			final List<UserDTO> users = responseUsers.stream()
										.map(mp -> mp.getBody())
										.collect(Collectors.toList());

			req.put("url", UserServiceApi.path + "/users");
			req.put("Users", users);

			Transaction entity = Transaction.builder().classe(dto.getClasse())
					.name("Teste Automatizado   Descrição:" + dto.getName()).payloadReq(req)
					.payloadRes(mapUser(responseUsers)).build();
			final var entitySaved = transactionRepository.save(entity);
			return mapper.toDto(entitySaved);
		}
		
		final var entity = mapper.toEntity(dto);
		final var entitySaved = transactionRepository.save(entity);
		return mapper.toDto(entitySaved);
	}

	@Override
	public List<TransactionDTO> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TransactionDTO find(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TransactionDTO update(TransactionDTO dto, Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private Map<String, Object> mapUser(List<ResponseEntity<UserDTO>> responseUsers){
 		final Map<String, Object> map = new HashMap<>();
 		if(responseUsers == null) {
 			map.put("ërro", "Resposta vazia ou nula");
 			return map;
 		}
 		
 		map.put("Total inclusos", responseUsers.size());
 		map.put("Pay Load Resposta", responseUsers);
 		return map;
 	}
}
