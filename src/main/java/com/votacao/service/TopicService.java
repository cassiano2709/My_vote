package com.votacao.service;


import com.votacao.dto.TopicCreateRequestDTO;
import com.votacao.dto.TopicDTO;
import com.votacao.entity.Topic;
import com.votacao.entity.Vote;
import com.votacao.repository.TopicRepository;
import com.votacao.repository.VoteRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@Service
@AllArgsConstructor
public class TopicService {

    private final TopicRepository repository;
    private final VoteRepository voteRepository;

    public TopicDTO create(TopicCreateRequestDTO topicRequest) {
        var pauta = repository.save(Topic.builder()
                .description(topicRequest.getDescription())
                .name(topicRequest.getName())
                .build());

        return TopicDTO.builder()
                .id(pauta.getId())
                .name(pauta.getName())
                .description(pauta.getDescription())
                .build();
    }

    public Topic findById(Long id){
      return repository.findById(id).orElseThrow(
              () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Id não localizado"));
    }

    public TopicDTO findDTOById(Long id){
        var topic = findById(id);
        return TopicDTO.builder()
                .id(topic.getId())
                .name(topic.getName())
                .description(topic.getDescription())
                .build();
    }

    public void delete(Long id){
        Topic topic = this.findById(id);
        repository.delete(topic);
    }

    public List<Topic> allVotes() {
        List<Topic> retorno = repository.findAll();
        for (Topic topic : retorno) {
            List<Vote> lstVotos = voteRepository.findAllByTopicId(topic.getId());
            long sim=0;
            long nao=0;
            for (Vote vote : lstVotos) {
                if (vote.getVote().equalsIgnoreCase("sim")) {
                    sim++;
                } else {
                    nao++;
                }
            }
            topic.setCountNo(nao);
            topic.setCountYes(sim);
        }
        return retorno;
    }
}
