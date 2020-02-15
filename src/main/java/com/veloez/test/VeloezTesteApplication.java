package com.veloez.test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.veloez.test.contract.dto.UserDTO;

@SpringBootApplication
public class VeloezTesteApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(VeloezTesteApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		//TODO descomentar para rodar teste
//		insertUsers(100);
	}
	
	@Value("${veloez.api.uri}")
	private String path;
	
	private void deleteAllUsers() {
		RestTemplate restTemplate = new RestTemplate();
//		ResponseEntity<UserDTO> response = restTemplate.postForEntity( path + "/users", user , UserDTO.class );
//		ResponseEntity<UserDTO> response = restTemplate.postForEntity( path + "/users", user , UserDTO.class );
		
	}
	
	private void deleteByIdUser(String id) {
		
	}
	
	private List<ResponseEntity<UserDTO>> insertUsers(int interacoes) {
		
		
//		HttpHeaders headers = new HttpHeaders();
//		headers.setContentType(MediaType.APPLICATION_JSON);
//
//		MultiValueMap<String, String> map= new LinkedMultiValueMap<String, String>();
//		map.add("email", "gabriell.is.huver@gmail.com");
//		map.add("password", "1234");
//		
//		HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);
		
		var listResponse = new ArrayList<ResponseEntity<UserDTO>>();
		
		for (int i = 0; i < interacoes; i++) {
			String uid = UUID.randomUUID().toString();
			var user = UserDTO.builder()
				.balance(BigDecimal.valueOf(20))
				.cpf("123123")
				.email("teste" + uid + "@gmail.com" )
				.name("teste api" + i)
				.password("teste123")
				.build();
			
			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<UserDTO> response = restTemplate.postForEntity( path + "/users", user , UserDTO.class );
			listResponse.add(response);
		}
		
		return listResponse;
	}

}
