package com.productservice.security.services;

import com.productservice.security.dtos.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AuthenticationService {
    private final RestTemplate restTemplate;

    public AuthenticationService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    public boolean authenticate(String token){
        ResponseEntity<User> response = restTemplate.postForEntity("http://localhost:9000/user/validate/" + token,
                null,
                User.class);
        return response.getBody() != null;
    }

}
