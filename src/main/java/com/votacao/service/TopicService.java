package com.votacao.service;


import com.votacao.dto.TopicCreateRequestDTO;
import com.votacao.dto.TopicDTO;
import com.votacao.entity.Topic;
import com.votacao.repository.TopicRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


@Service
public class TopicService {

    public TopicRepository repository;

    public TopicDTO create(TopicCreateRequestDTO topicRequest) {

        var pauta = repository.save(Topic.builder()
                .description(topicRequest.getDescription())
                .name(topicRequest.getName())
                .build());

        return TopicDTO.builder()
                .name(pauta.getName())
                .description(pauta.getDescription())
                .build();
    }

    public Topic findById(Long id){
      return repository.findById(id).orElseThrow(
              () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Não rolou"));
    }
    
    public void delete(Long id){
        repository.deleteById(id);
    }
}
