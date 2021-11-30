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
public class SessionCreateRequestDTO {

    private Long topicId;
    private LocalDate startDateTime;
    private LocalDate finishDateTime;


}
