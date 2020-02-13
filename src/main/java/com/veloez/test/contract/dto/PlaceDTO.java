package com.veloez.test.contract.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PlaceDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotNull
    private String name;
    @NotNull
    private String email;
    @NotNull
    private String doc;
    @NotNull
    private String password;
    
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss.SSS")
	private LocalDateTime created;

	@JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss.SSS")
	private LocalDateTime updated;

	//  private location costPrice;
    // location: { type: PointSchema, index: '2dsphere' },
}
