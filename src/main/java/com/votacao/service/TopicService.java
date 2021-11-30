package com.votacao.service;


import com.votacao.dto.SessionDTO;
import com.votacao.dto.TopicCreateRequestDTO;
import com.votacao.dto.TopicDTO;
import com.votacao.entity.Topic;
import com.votacao.repository.TopicRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


@Service
@AllArgsConstructor
public class TopicService {

    private final TopicRepository repository;

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
              () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Não rolou"));
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
        repository.deleteById(id);
    }
}
