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

import com.veloez.test.contract.dto.UserDTO;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RequestMapping("/Users")
public interface UserApi extends GenericApi<UserDTO, UserDTO> 
{
	@ApiOperation(value="Inclusão de User")
	@PostMapping()
	public ResponseEntity<Void> save(@Valid @RequestBody UserDTO dto);
	
	@ApiOperation(value="Busca por User-id") 
	@ApiResponses(value = {
			@ApiResponse(code = 404, message = "User não encontrado") })
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<UserDTO> find(@PathVariable Long id);
		
	@ApiOperation(value="Busca por todos User")
	@ApiResponses(value = {
			@ApiResponse(code = 404, message = "nenhum User encontrado") })
	@GetMapping
	public ResponseEntity<List<UserDTO>> findAll();
	
	@ApiOperation(value="Alterar por User-id")
	@ApiResponses(value = {
			@ApiResponse(code = 404, message = "User não encontrado") })
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<UserDTO> update(final @Valid @RequestBody UserDTO dto, Long id);

//	@ApiOperation(value="Busca De User Paginada")
//	@ApiResponses(value = {
//			@ApiResponse(code = 404, message = "nenhum cliente encontrado") })
//	@GetMapping("/paginate")
//	ResponseEntity<PaginatedResourceDTO<UserDTO>> findPaginate(@SpringQueryMap @Valid final UserFiltersDTO filters);
}
