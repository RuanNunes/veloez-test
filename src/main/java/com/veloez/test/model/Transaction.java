package com.veloez.test.model;

import java.io.Serializable;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import com.veloez.test.model.type.JsonDataUserType;

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
@SequenceGenerator(name = "sequence_generator", sequenceName = "SEQ_TRANSACTION", allocationSize = 1)
@TypeDefs({@TypeDef(name = "JsonDataObject", typeClass = JsonDataUserType.class)})
public class Transaction extends PersistentEntity implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@NotNull
	private String name;
	
	@Column(name = "payload_req", columnDefinition = "jsonb", nullable = false, updatable = false)
	@Type(type = "JsonDataObject")
	private Map<String, Object> payloadReq;
	
	@Column(name = "payload_res", columnDefinition = "jsonb", nullable = false, updatable = false)
	@Type(type = "JsonDataObject")
	private Map<String, Object> payloadRes;

	@NotNull
	@Enumerated(EnumType.STRING)
	private Classe classe;

	private String error;
	

}
