package com.votacao.service;

import com.votacao.dto.PartnerVoteCreateRequestDTO;
import com.votacao.dto.VoteCreateRequestDTO;
import com.votacao.entity.Vote;
import com.votacao.repository.PartnerRepository;
import com.votacao.repository.VoteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class VoteService {

    private  VoteRepository repository;
    private  PartnerRepository partnerRepository;
    private  SessionService sessionService;




    public void openVote(VoteCreateRequestDTO voteCreateRequestDTO) {
        //List<Partner> partnerList = partnerRepository.findAll();
        for (PartnerVoteCreateRequestDTO partner1 :voteCreateRequestDTO.getPatnerVote()) {
            repository.save(Vote.builder()
                    .partnerId(partner1.getPartnerId())
                    .sessionId(voteCreateRequestDTO.getSessionId())
                    .topicId(voteCreateRequestDTO.getTopicId())
                    .vote(partner1.getVote())
                    .build());
        }
    }





}