package com.votacao.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class TopicDTO {

    private Long id;
    private String name;
    private String description;
    private Long countYes;
    private Long countNo;
}
