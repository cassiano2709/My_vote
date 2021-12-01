package com.votacao.service;


import com.votacao.dto.PartnerCreateRequestDTO;
import com.votacao.dto.PartnerDTO;
import com.votacao.entity.Partner;
import com.votacao.entity.Topic;
import com.votacao.repository.PartnerRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@AllArgsConstructor
public class PartnerService {

    private final PartnerRepository repository;

    public PartnerDTO create (PartnerCreateRequestDTO partnerCreateRequestDTO){
         var partner = repository.save(Partner.builder()
                         .name(partnerCreateRequestDTO.getNome())
                         .cpf(partnerCreateRequestDTO.getCpf())
                         .build());

         return PartnerDTO.builder()
                 .id(partner.getId())
                 .nome(partner.getName())
                 .cpf(partner.getCpf())
                 .build();
    }

    public Partner findById(Long id){
        return repository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Id não localizado"));
    }

    public void deletePartner(Long id){
        Partner partner = this.findById(id);
        repository.delete(partner);
    }

}
