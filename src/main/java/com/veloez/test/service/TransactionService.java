package com.veloez.test.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.veloez.test.contract.dto.TransactionDTO;
import com.veloez.test.contract.dto.UserDTO;
import com.veloez.test.mapper.TransactionMapper;
import com.veloez.test.model.Classe;
import com.veloez.test.model.Transaction;
import com.veloez.test.repository.TransactionRepository;
import com.veloez.test.service.exception.ResourceNotFoundException;

@Service
public class TransactionService implements GenericService<TransactionDTO, TransactionDTO>{
	
	@Autowired
	private TransactionRepository transactionRepository;
	
	@Autowired
	private TransactionMapper mapper;
		
	@Override
	public TransactionDTO save(TransactionDTO dto) {
		if (Classe.USER.equals(dto.getClasse())) {
			try {
				final var responseUsers = saveRestUsers(12);
				final Map<String, Object> req = new HashMap<>();
				final List<UserDTO> users = new ArrayList<>(); 
				
				for (ResponseEntity<UserDTO> user : responseUsers) {
					users.add(user.getBody());
				}
				
				req.put("url", path + "/users");
				req.put("Users", users);
				
				Transaction entity = Transaction.builder()
						.classe(dto.getClasse())
						.name("Teste Automatizado   Descrição:" + dto.getName())
						.payloadReq(req)
						.payloadRes(mapUser(responseUsers))
						.build();
				final var entitySaved = transactionRepository.save(entity);
				return mapper.toDto(entitySaved);
				
			} catch (Exception e) {
			
			}
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
	
	@Value("${veloez.api.uri}")
	private String path;
	
	private List<ResponseEntity<UserDTO>> saveRestUsers(int interacoes) {
		var listResponse = new ArrayList<ResponseEntity<UserDTO>>();
		
		for (int i = 0; i < interacoes; i++) {
			String uid = UUID.randomUUID().toString();
			var user = UserDTO.builder()
				.balance(BigDecimal.valueOf(20))
				.cpf("123123")
				.email("teste" + uid + "@gmail.com" )
				.name("teste automatizado api" + i)
				.password("teste123")
				.build();
			
			RestTemplate restTemplate = new RestTemplate();
			
			try {
				ResponseEntity<UserDTO> response = restTemplate.postForEntity( path + "/users", user , UserDTO.class );
				listResponse.add(response);
			} catch (Exception e) {
				new ResourceNotFoundException("erro ao fazer chamada rest para users");
			} 		
		}
		
		return listResponse;
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
//	
//	
//	@Autowired
//	private CostumerMapper mapper;
//	
//	@Override
//	public CostumerDTO save(final CostumerDTO dto) {
//		if((dto.getId() != null)) 
//			dto.setId(null);
//		
//		final Customer entity = mapper.toEntity(dto);
//		return mapper.toDto(customerRepository.save(entity));
//	}
	
//	@Override
//	public List<CostumerDTO> findAll(){
//		final var custumers = customerRepository.findAll();
//		
//		if(custumers.isEmpty())
//			new ObjectNotFoundException("Não existe usuarios cadastrados");
//		
//		return mapper.toDto(custumers);
//	}
	
//	@Override
//	public CostumerDTO find(Long id) {
//		
//		//TODO descomentar quando implementação de spring security for configurada
////		UserSS user = UserService.authenticated();
////		
////		if(user==null || !user.hasRole(Perfil.ADMIN) && !id.equals(user.getId())) {
////			throw new AuthorizationException("Acesso negado.");
////		}
//		
//		Optional<Customer> obj = customerRepository.findById(id);
//		
//		return mapper.toDto(obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: "+id+", Tipo: "+ Customer.class.getName())));
//	}

//	@Override
//	public CostumerDTO update(final CostumerDTO dto, final Long id) {
//		final Customer entity = customerRepository.findById(id)
//				.orElseThrow(ResourceNotFoundException.supply());
//		final Customer updateEntity = mapper.updateEntity(entity, dto);
//		final Customer updatedEntity = customerRepository.save(updateEntity);
//		return mapper.toDto(updatedEntity);
//	}
}
