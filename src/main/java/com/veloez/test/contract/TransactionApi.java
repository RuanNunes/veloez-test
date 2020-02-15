package com.veloez.test.contract;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.veloez.test.contract.dto.TransactionDTO;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RequestMapping("/api/test/transactions")
public interface TransactionApi extends GenericApi<TransactionDTO, TransactionDTO> 
{
	
	
	@ApiOperation(value="Inclusão de Transação")
	@PostMapping()
	public ResponseEntity<Void> save(@Valid @RequestBody TransactionDTO dto);
	
	@ApiOperation(value="Busca por transaction-id") 
	@ApiResponses(value = {
			@ApiResponse(code = 404, message = "Transação não encontrado") })
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<TransactionDTO> find(@PathVariable Long id);
		
	@ApiOperation(value="Busca por todas Transacões")
	@ApiResponses(value = {
			@ApiResponse(code = 404, message = "nenhu encontrado") })
	@GetMapping
	public ResponseEntity<List<TransactionDTO>> findAll();
	
	@ApiOperation(value="Alterar por User-id")
	@ApiResponses(value = {
			@ApiResponse(code = 404, message = "User não encontrado") })
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<TransactionDTO> update(final @Valid @RequestBody TransactionDTO dto, Long id);

//	@ApiOperation(value="Busca De User Paginada")
//	@ApiResponses(value = {
//			@ApiResponse(code = 404, message = "nenhum cliente encontrado") })
//	@GetMapping("/paginate")
//	ResponseEntity<PaginatedResourceDTO<UserDTO>> findPaginate(@SpringQueryMap @Valid final UserFiltersDTO filters);
}
