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
public class SessionDTO {

    private Long id;
    private LocalDateTime startDateTime;
    private LocalDateTime finishDateTime;
    private boolean openSession;

}
