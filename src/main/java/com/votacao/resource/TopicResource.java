package com.votacao.resource;


import com.votacao.dto.TopicCreateRequestDTO;
import com.votacao.dto.TopicDTO;
import com.votacao.service.TopicService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/topic")
@RequiredArgsConstructor
public class TopicResource {

    public final TopicService service;

    @PostMapping
    @ResponseStatus(CREATED)
    public TopicDTO create(@Valid @RequestBody TopicCreateRequestDTO topicrequest) {
        return service.create(topicrequest);
    }
}
