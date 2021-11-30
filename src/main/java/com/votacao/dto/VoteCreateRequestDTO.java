package com.votacao.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class VoteCreateRequestDTO {

    Long sessionId;
    Long topicId;
    List<PartnerVoteCreateRequestDTO> patnerVote;

}
