package com.votacao.service;

import com.votacao.dto.PartnerVoteCreateRequestDTO;
import com.votacao.dto.VoteCreateRequestDTO;
import com.votacao.dto.VoteDTO;
import com.votacao.entity.Topic;
import com.votacao.entity.Vote;
import com.votacao.repository.PartnerRepository;
import com.votacao.repository.VoteRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@AllArgsConstructor
public class VoteService {

    private  VoteRepository repository;
    private TopicService topicService;
    private  PartnerRepository partnerRepository;
    private  SessionService sessionService;

    public void openVote(VoteCreateRequestDTO voteCreateRequestDTO) {
         topicService.allVotes();
        for (PartnerVoteCreateRequestDTO partner1 :voteCreateRequestDTO.getPartnerVote()) {
            repository.save(Vote.builder()
                    .partnerId(partner1.getPartnerId())
                    .sessionId(voteCreateRequestDTO.getSessionId())
                    .topicId(voteCreateRequestDTO.getTopicId())
                    .vote(partner1.getVote())
                    .build());
        }
    }

    public Vote findById(Long id){
        return repository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Id não localizado"));
    }

    public  void delete(Long id){
        Vote vote = this.findById(id);
        repository.delete(vote);
    }




}