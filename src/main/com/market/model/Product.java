package com.market.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@Entity
public class Product extends PersistentEntity implements Serializable{
	private static final long serialVersionUID = 1L;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customer_id")
	private Customer customer;


	//Cria tabela auxiliar para fazer ligação de muitos para muitos entre rule e produtos
	//TODO analizar futuramente se precisa de ligação entre rule e product
//	@ManyToMany
//	@JoinTable(name = "product_rule",
//			joinColumns = @JoinColumn(name = "product_id"),
//			inverseJoinColumns = @JoinColumn(name = "rule_id" )
//	)
//	private Set<RuleMarketPlace> rules = new HashSet<>();

	@NotNull
	private String name;
	private String description;
	private String sku;
	private BigDecimal price;
	@NotNull
	private BigDecimal costPrice;
}
