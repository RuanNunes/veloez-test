package com.veloez.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

import com.veloez.test.contract.dto.SessionDTO;
import com.veloez.test.contract.dto.TokenDTO;
import com.veloez.test.service.UserServiceApi;

@SpringBootApplication
public class VeloezTesteApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(VeloezTesteApplication.class, args);
	}
	
	@Autowired
	private UserServiceApi userServiceApi;

	@Override
	public void run(String... args) throws Exception {
		final var session = session();
		//Testes automatizados
		userServiceApi.saveMany(2);
		userServiceApi.findUsers(session);
		
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
}
