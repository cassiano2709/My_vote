package com.votacao.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class VoteDTO {

    private Long voteId;
    private String partenerCpf;
    private Boolean vote;
    private Long partenerId;
    private LocalDateTime startDateTime;
    private LocalDateTime finishDateTime;
    private Long countYes;
    private Long countNo;

}