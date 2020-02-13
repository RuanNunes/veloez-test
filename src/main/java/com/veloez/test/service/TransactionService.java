package com.veloez.test.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.veloez.test.contract.dto.TransactionDTO;

@Service
public class TransactionService implements GenericService<TransactionDTO, TransactionDTO>{

	@Override
	public TransactionDTO save(TransactionDTO dto) {
		// TODO Auto-generated method stub
		return null;
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
//	@Autowired
//	private CustomerRepository customerRepository;
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
