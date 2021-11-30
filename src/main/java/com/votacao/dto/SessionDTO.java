package com.votacao.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class SessionDTO {

    private Long id;
    private TopicDTO topicDTO;
    private LocalDate startDateTime;
    private LocalDate finishDateTime;
    private boolean openSession;

}
