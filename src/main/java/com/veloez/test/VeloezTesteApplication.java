package com.veloez.test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.veloez.test.contract.dto.SessionDTO;
import com.veloez.test.contract.dto.TokenDTO;
import com.veloez.test.contract.dto.UserDTO;

@SpringBootApplication
public class VeloezTesteApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(VeloezTesteApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		final var session = session();
		//TODO descomentar para rodar teste
//		insertUsers(100);
	}
	
	@Value("${veloez.api.uri}")
	private String path;

	private RestTemplate restTemplate = new RestTemplate();
	
	
	private TokenDTO session() {
		final var session = SessionDTO.builder()
				.email("gabriell.is.huver@gmail.com")
				.password("1234")
				.build();
		final var responseToken = restTemplate.postForEntity(path + "/sessions", session, TokenDTO.class);
		return responseToken.getBody();
	}
	
	private void deleteAllUsers() {

//		ResponseEntity<UserDTO> response = restTemplate.postForEntity( path + "/users", user , UserDTO.class );
//		ResponseEntity<UserDTO> response = restTemplate.postForEntity( path + "/users", user , UserDTO.class );
		
	}
	
	private void deleteByIdUser(String id) {
		
	}
	
	private List<ResponseEntity<UserDTO>> insertUsers(int interacoes) {
		var listResponse = new ArrayList<ResponseEntity<UserDTO>>();
		
		for (int i = 0; i < interacoes; i++) {
			final String uid = UUID.randomUUID().toString();
			final var user = UserDTO.builder()
				.balance(BigDecimal.valueOf(20))
				.cpf("123123")
				.email("teste" + uid + "@gmail.com" )
				.name("teste api" + i)
				.password("teste123")
				.build();
			
			final ResponseEntity<UserDTO> response = restTemplate.postForEntity( path + "/users", user , UserDTO.class );
			listResponse.add(response);
		}
		return listResponse;
	}

}
