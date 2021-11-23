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
public class ParticipantDTO {

    private Long id;
    private String participant;
    private Long sessionId;
    private LocalDateTime startDateTime;
    private LocalDateTime finishDateTime;
    private LocalDateTime date;
}
