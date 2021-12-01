package com.votacao.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class PartnerVoteCreateRequestDTO {

    Long partnerId;
    String vote;
}
