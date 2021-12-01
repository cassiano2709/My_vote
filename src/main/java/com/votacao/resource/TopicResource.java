package com.votacao.resource;


import com.votacao.dto.TopicCreateRequestDTO;
import com.votacao.dto.TopicDTO;
import com.votacao.entity.Topic;
import com.votacao.service.TopicService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/topic")
@RequiredArgsConstructor
public class TopicResource {

    public final TopicService service;

    @PostMapping
    @ResponseStatus(CREATED)
    public TopicDTO create(@Valid @RequestBody TopicCreateRequestDTO topicRequest) {
        return service.create(topicRequest);
    }

    @GetMapping("/{id}")
    @ResponseStatus(OK)
    public TopicDTO findDTOById(@Valid @RequestParam Long id){

        return service.findDTOById(id);
    }

    @DeleteMapping
    @ResponseStatus(OK)
    public void delete(@Valid @RequestParam Long id){

        service.delete(id);
    }
}
