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
public class ParticipantResultDTO {

    private Long id;
    private String participant;
    private LocalDateTime date;
    private Long sessionId;
    private LocalDateTime startDateTime;
    private LocalDateTime finishDateTime;
    private long votespositive;
    private long votesNegative;

    public long resultDefinition() {
       if(votespositive > votesNegative){
           return votespositive;
        }else{
           return votesNegative;
       }
    }
}
