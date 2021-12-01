package com.votacao.resource;

import com.votacao.dto.PartnerCreateRequestDTO;
import com.votacao.dto.PartnerDTO;
import com.votacao.entity.Partner;
import com.votacao.service.PartnerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;


@RestController
@RequestMapping("/partner")
@RequiredArgsConstructor
public class PartnerResource {

    private final PartnerService service;

    @PostMapping
    @ResponseStatus(CREATED)
    public PartnerDTO create(@Valid @RequestBody PartnerCreateRequestDTO partner) {
      return service.create(partner);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(OK)
    public void deletePartner(@Valid @RequestParam Long id){

        service.deletePartner(id);
    }


    @GetMapping("/{id}")
    @ResponseStatus(OK)
    public Partner findById(@Valid @RequestParam Long id){

        return service.findById(id);
    }

}
