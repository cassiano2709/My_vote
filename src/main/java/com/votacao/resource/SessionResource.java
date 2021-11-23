package com.votacao.resource;

import com.votacao.dto.SessionCreateRequestDTO;
import com.votacao.dto.SessionDTO;
import com.votacao.dto.SessionUpdateRequestDTO;
import com.votacao.service.SessionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static org.springframework.http.HttpStatus.CREATED;


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
    public SessionDTO findById(@PathVariable Long id) {
        return service.findDTOById(id);
    }

    @GetMapping("/{sessionId}")
    public Boolean openSession(@PathVariable Long sessionId) {
        return service.SessionOpen(sessionId);
    }

    @PutMapping
    public SessionDTO update(@Valid @RequestBody SessionUpdateRequestDTO request) {
        return service.updateSession(request);
    }

}
