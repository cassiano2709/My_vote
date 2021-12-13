package com.votacao.resource;


import com.votacao.service.ApiExternService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static org.springframework.http.HttpStatus.OK;


@RestController
@RequestMapping("/apiExtern")
@RequiredArgsConstructor
public class ApiExternResource {

    private final ApiExternService service;

    @GetMapping("/{cpf}")
    @ResponseStatus(OK)
    public String findCPF(@Valid @RequestParam String cpf){
        return service.findCPF(cpf);
    }
}
