package com.votacao.resource;

import com.votacao.dto.SessionCreateRequestDTO;
import com.votacao.dto.SessionDTO;
import com.votacao.entity.Topic;
import com.votacao.service.SessionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;


@RestController
@RequestMapping("/session")
@RequiredArgsConstructor
public class SessionResource {

    private final SessionService service;

    @PostMapping
    @ResponseStatus(CREATED)
    public SessionDTO create(@Valid @RequestBody SessionCreateRequestDTO request) {
        return service.create(request);
    }

    @GetMapping("/{id}")
    @ResponseStatus(OK)
    public SessionDTO findById(@PathVariable Long id) {
        return service.findDTOById(id);
    }

    @GetMapping("/{sessionId}")
    @ResponseStatus(OK)
    public Boolean openSession(@PathVariable Long sessionId, Topic topic) {
        return service.SessionOpen(sessionId, topic);
    }

//    @PutMapping
//    public SessionDTO update(@Valid @RequestBody SessionUpdateRequestDTO request) {
//        return service.updateSession(request);
//    }

}
