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

import com.veloez.test.contract.dto.BiometricDocumentDTO;
import com.veloez.test.contract.dto.PlaceDTO;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RequestMapping("/api/v1/products/")
public interface BiometricDocumentApi extends GenericApi<BiometricDocumentDTO, BiometricDocumentDTO> {

//    @Override
//    @ApiOperation(value="Inclusão de product")
//    @PostMapping()
//    public ResponseEntity<Void> save(final @Valid @RequestBody PlaceDTO dto);
//
//    @Override
//    @ApiOperation(value="Busca por product-id")
//    @ApiResponses(value = {
//            @ApiResponse(code = 404, message = "Product não encontrado") })
//    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
//    public ResponseEntity<PlaceDTO> find(final @PathVariable Long id);
//
//    @Override
//    @ApiOperation(value="Busca por todos product")
//    @ApiResponses(value = {
//            @ApiResponse(code = 404, message = "Nenhum product encontrado") })
//    @GetMapping
//    public ResponseEntity<List<PlaceDTO>> findAll();
//
//    @Override
//    @ApiOperation(value="Alterar por product-id")
//    @ApiResponses(value = {
//            @ApiResponse(code = 404, message = "Product não encontrado") })
//    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
//    public ResponseEntity<PlaceDTO> update(final @Valid @RequestBody PlaceDTO dto, final Long id);

//    @ApiOperation(value="Busca De Products Paginada")
//    @ApiResponses(value = {
//            @ApiResponse(code = 404, message = "nenhum product encontrado") })
//    @GetMapping("/paginate")
//    ResponseEntity<PaginatedResourceDTO<PlaceDTO>> findPaginate(@SpringQueryMap @Valid final ProductFiltersDTO filters);


}
