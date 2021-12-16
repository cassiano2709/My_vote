package com.votacao.service;

import com.votacao.entity.ApiExtern;
import com.votacao.entity.Partner;
import lombok.AllArgsConstructor;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
@AllArgsConstructor
public class ApiExternService {

    public String findCPF(String cpf) {

        String uri = "https://user-info.herokuapp.com/users/" + cpf;

        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(uri, String.class);
    }
}

