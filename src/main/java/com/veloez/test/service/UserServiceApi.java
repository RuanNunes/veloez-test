package com.veloez.test.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.veloez.test.contract.dto.TokenDTO;
import com.veloez.test.contract.dto.UserDTO;
import com.veloez.test.service.exception.ResourceNotFoundException;

public class UserServiceApi implements GenericService<UserDTO, UserDTO>{
    @Value("${veloez.api.uri}")
    protected static String path;
    @Override
    public UserDTO save(final UserDTO dto) {
		if (dto == null) {
			final String uid = UUID.randomUUID().toString();
			final var user = UserDTO.builder().balance(BigDecimal.valueOf(20)).cpf("123123")
					.email("teste" + uid + "@gmail.com").name("teste automatizado api").password("teste123").build();
			return user;
		}
		return saveRest(dto).getBody();
    }
    
    public List<ResponseEntity<UserDTO>> saveMany(int interacoes) {
        final var listResponse = new ArrayList<ResponseEntity<UserDTO>>();

        for (int i = 0; i < interacoes; i++) {
            final var users = saveRest(save(null));
            listResponse.add(users);
        }
        return listResponse;
    }
    private RestTemplate restTemplate = new RestTemplate();
    private ResponseEntity<UserDTO> saveRest(UserDTO dto) {
    	try {
    		final ResponseEntity<UserDTO> response = restTemplate.postForEntity(path + "/users", dto,
					UserDTO.class);
			return response;
		} catch (Exception e) {
			throw new ResourceNotFoundException("erro ao fazer chamada rest para users");
		}
    }

    @Override
    public List<UserDTO> findAll() {
        return null;
    }

    @Override
    public UserDTO find(Long id) {
        return null;
    }
    
	public List<UserDTO> findUsers(final TokenDTO tokenDTO){
		final String url = path + "/users";
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.add("Authorization", "Bearer " + tokenDTO.getToken());
		
		HttpEntity entity = new HttpEntity(headers);

		ResponseEntity<String> response = restTemplate.exchange(
		    url, HttpMethod.GET, entity, String.class);
		//ResponseEntity<String> response = restTemplate.getForEntity(url, String.class , entity);
		return null;
	}

    @Override
    public UserDTO update(UserDTO dto, Long id) {
        return null;
    }
}
