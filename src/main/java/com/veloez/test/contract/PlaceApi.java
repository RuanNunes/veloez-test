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

import com.veloez.test.contract.dto.PlaceDTO;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RequestMapping("/veloez/test/places/")
public interface PlaceApi extends GenericApi<PlaceDTO, PlaceDTO> {
	
	@Override
	@ApiOperation(value="Inclusão de Place")
	@PostMapping()
	public ResponseEntity<Void> save(@Valid @RequestBody PlaceDTO dto);
	
	@Override
	@ApiOperation(value="Busca por place-id") 
	@ApiResponses(value = {
			@ApiResponse(code = 404, message = "place não encontrado") })
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<PlaceDTO> find(@PathVariable Long id);
	
	@Override
	@ApiOperation(value="Busca por todas rules") 
	@ApiResponses(value = {
			@ApiResponse(code = 404, message = "nenhum place encontrada") })
	@GetMapping()
	public ResponseEntity<List<PlaceDTO>> findAll();

	//TODO descomentar quando for implementado spring security
	//@PreAuthorize("hasAnyRole('ADMIN')")
	@Override
	@ApiOperation(value="Alterar place")
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<PlaceDTO> update(@Valid @RequestBody PlaceDTO objDTO, @PathVariable Long id);

//	@ApiOperation(value="Busca De Rules Paginada")
//	@ApiResponses(value = {
//			@ApiResponse(code = 404, message = "nenhuma rule encontrada") })
//	@GetMapping("/paginate")
//	ResponseEntity<PaginatedResourceDTO<BiometricDocumentDTO>> findPaginate(@SpringQueryMap @Valid final RuleMarketPlaceFiltersDTO filters);

}
