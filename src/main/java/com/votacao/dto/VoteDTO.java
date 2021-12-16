package com.votacao.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class VoteDTO {

    Long Id;
    private Long partnerId;
    private Long sessionId;
    private Long topicId;
    private String vote;
    private String cpf;

}